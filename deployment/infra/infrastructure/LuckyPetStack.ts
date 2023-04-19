import { Stack, StackProps } from 'aws-cdk-lib'
import { LambdaIntegration, RestApi } from 'aws-cdk-lib/aws-apigateway'
import { PolicyStatement } from 'aws-cdk-lib/aws-iam'
import { NodejsFunction } from 'aws-cdk-lib/aws-lambda-nodejs'
import { Construct } from 'constructs'
import { join } from 'path'
import { GenericTable } from './GenericTable'

export class LuckyPetStack extends Stack {
  private api = new RestApi(this, 'LuckyPetApi')
  // private luckyPetTable = new GenericTable('LuckyPetTable', 'luckyPetId', this)
  private luckyPetTable = new GenericTable(this, {
    tableName: 'LuckyPetTable',
    primaryKey: 'luckyPetId',
    createLambdaPath: 'Create',
  })

  constructor(scope: Construct, id: string, props: StackProps) {
    super(scope, id, props)

    const helloLambdaNodeJS = new NodejsFunction(this, 'HelloLambdaNodeJS', {
      entry: join(__dirname, '..', 'services', 'node-lambda', 'hello.ts'),
      handler: 'handler',
    })

    const s3ListPolicy = new PolicyStatement()
    s3ListPolicy.addActions('s3:ListAllMyBuckets')
    s3ListPolicy.addResources('*')
    helloLambdaNodeJS.addToRolePolicy(s3ListPolicy)

    const helloLambdaIntegration = new LambdaIntegration(helloLambdaNodeJS)
    const helloLambdaResource = this.api.root.addResource('hell')
    helloLambdaResource.addMethod('GET', helloLambdaIntegration)

    //luckypet api integrations
    const luckyPetResource = this.api.root.addResource('pets')
    luckyPetResource.addMethod(
      'POST',
      this.luckyPetTable.createLambdaIntegration
    )
  }
}
