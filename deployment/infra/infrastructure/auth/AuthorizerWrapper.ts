import { CfnOutput } from 'aws-cdk-lib'
import { CognitoUserPoolsAuthorizer, RestApi } from 'aws-cdk-lib/aws-apigateway'
import {
  UserPool,
  UserPoolClient,
  CfnUserPoolGroup,
} from 'aws-cdk-lib/aws-cognito'
import { Construct } from 'constructs'
import { IdentityPoolWrapper } from './IdentityPoolWrapper'

export class AuthorizerWrapper {
  private scope: Construct
  private api: RestApi

  private userPool: UserPool
  private userPoolClient: UserPoolClient
  private identityPoolWrapper: IdentityPoolWrapper
  private photoBucketArn: string
  public authorizer: CognitoUserPoolsAuthorizer

  constructor(scope: Construct, api: RestApi, photoBucketArn: string) {
    this.scope = scope
    this.api = api
    this.photoBucketArn = photoBucketArn
    this.initialize()
  }

  private initialize() {
    this.createUserPool()
    this.addUserPoolClient()
    this.createAuthorizer()
    this.initializeIdentityPoolWrapper()
    this.createAdminGroup()
  }

  private createUserPool() {
    this.userPool = new UserPool(this.scope, 'LuckyPetUserPool', {
      userPoolName: 'LuckyPetUserPool',
      selfSignUpEnabled: true,
      signInAliases: {
        email: true,
        username: true,
      },
    })

    new CfnOutput(this.scope, 'UserPoolId', {
      value: this.userPool.userPoolId,
    })
  }

  private addUserPoolClient() {
    this.userPoolClient = this.userPool.addClient('LuckyPetUserPoolClient', {
      userPoolClientName: 'LuckyPetUserPool-Client',
      authFlows: {
        adminUserPassword: true,
        custom: true,
        userPassword: true,
        userSrp: true,
      },
      generateSecret: false,
    })
    new CfnOutput(this.scope, 'UserPoolClientId', {
      value: this.userPoolClient.userPoolClientId,
    })
  }

  private createAuthorizer() {
    this.authorizer = new CognitoUserPoolsAuthorizer(
      this.scope,
      'LuckyPetUserAuthorizer',
      {
        cognitoUserPools: [this.userPool],
        authorizerName: 'LuckyPetUserAuthorizer',
        identitySource: 'method.request.header.Authorization',
      }
    )
    this.authorizer._attachToApi(this.api)
  }

  private createAdminGroup() {
    new CfnUserPoolGroup(this.scope, 'LuckyPetAdmin', {
      groupName: 'LuckyPetAdmin',
      userPoolId: this.userPool.userPoolId,
      roleArn: this.identityPoolWrapper.adminRole.roleArn,
    })
  }

  private initializeIdentityPoolWrapper() {
    this.identityPoolWrapper = new IdentityPoolWrapper(
      this.scope,
      this.userPool,
      this.userPoolClient,
      this.photoBucketArn
    )
  }
}
