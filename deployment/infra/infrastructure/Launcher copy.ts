import { LuckyPetStack } from './LuckyPetStack'
import { App } from 'aws-cdk-lib'

const app = new App()
new LuckyPetStack(app, 'LuckyPetStack', {
  stackName: 'LuckyPetStack',
})
