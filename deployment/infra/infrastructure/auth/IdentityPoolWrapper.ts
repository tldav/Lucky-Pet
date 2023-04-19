import { CfnOutput } from 'aws-cdk-lib'
import { RestApi } from 'aws-cdk-lib/aws-apigateway'
import {
  CfnIdentityPool,
  CfnIdentityPoolRoleAttachment,
  UserPool,
  UserPoolClient,
} from 'aws-cdk-lib/aws-cognito'
import {
  Effect,
  FederatedPrincipal,
  PolicyStatement,
  Role,
} from 'aws-cdk-lib/aws-iam'
import { Construct } from 'constructs'

export class IdentityPoolWrapper {
  private scope: Construct
  private api: RestApi

  private userPool: UserPool
  private userPoolClient: UserPoolClient
  private identityPool: CfnIdentityPool
  private authenticatedRole: Role
  private unauthenticatedRole: Role
  public adminRole: Role
  private photoBucketArn: string

  constructor(
    scope: Construct,
    userPool: UserPool,
    userPoolClient: UserPoolClient,
    photoBucketArn: string
  ) {
    this.scope = scope
    this.userPool = userPool
    this.userPoolClient = userPoolClient
    this.photoBucketArn = photoBucketArn
    this.initialize()
  }

  private initialize() {
    this.initializeIdentityPool()
    this.initializeRoles()
    this.attachRoles()
  }

  private initializeIdentityPool() {
    this.identityPool = new CfnIdentityPool(
      this.scope,
      'LuckyPetIdentityPool',
      {
        allowUnauthenticatedIdentities: true,
        cognitoIdentityProviders: [
          {
            clientId: this.userPoolClient.userPoolClientId,
            providerName: this.userPool.userPoolProviderName,
          },
        ],
      }
    )
    new CfnOutput(this.scope, 'LuckyPetIdentityPoolId', {
      value: this.identityPool.ref,
    })
  }

  private initializeRoles() {
    this.authenticatedRole = new Role(this.scope, 'CognitoAuthRole', {
      assumedBy: new FederatedPrincipal(
        'cognito-identity.amazonaws.com',
        {
          StringEquals: {
            'cognito-identity.amazonaws.com:aud': this.identityPool.ref,
          },
          'ForAnyValue:StringLike': {
            'cognito-identity.amazonaws.com:amr': 'authenticated',
          },
        },
        'sts:AssumeRoleWithWebIdentity'
      ),
    })

    this.unauthenticatedRole = new Role(this.scope, 'LuckyPetUnAuthRole', {
      assumedBy: new FederatedPrincipal(
        'cognito-identity.amazonaws.com',
        {
          StringEquals: {
            'cognito-identity.amazonaws.com:aud': this.identityPool.ref,
          },
          'ForAnyValue:StringLike': {
            'cognito-identity.amazonaws.com:amr': 'unauthenticated',
          },
        },
        'sts:AssumeRoleWithWebIdentity'
      ),
    })

    this.adminRole = new Role(this.scope, 'LuckyPetAdminRole', {
      assumedBy: new FederatedPrincipal(
        'cognito-identity.amazonaws.com',
        {
          StringEquals: {
            'cognito-identity.amazonaws.com:aud': this.identityPool.ref,
          },
          'ForAnyValue:StringLike': {
            'cognito-identity.amazonaws.com:amr': 'authenticated',
          },
        },
        'sts:AssumeRoleWithWebIdentity'
      ),
    })

    this.adminRole.addToPolicy(
      new PolicyStatement({
        effect: Effect.ALLOW,
        actions: ['s3:PutObject', 's3:PutObjectAcl'],
        resources: [this.photoBucketArn],
      })
    )
  }

  private attachRoles() {
    new CfnIdentityPoolRoleAttachment(this.scope, 'RolesAttachment', {
      identityPoolId: this.identityPool.ref,
      roles: {
        authenticated: this.authenticatedRole.roleArn,
        unauthenticated: this.unauthenticatedRole.roleArn,
      },
      roleMappings: {
        adminsMapping: {
          type: 'Token',
          ambiguousRoleResolution: 'AuthenticatedRole',
          identityProvider: `${this.userPool.userPoolProviderName}:${this.userPoolClient.userPoolClientId}`,
        },
      },
    })
  }
}
