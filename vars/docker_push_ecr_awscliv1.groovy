#!/usr/bin/env groovy 
// Usage example
// stage('push-image'){
//     steps{
//         script{
//             docker_push_ecr_awscliv1 (IMAGE_NAME: "node", IMAGE_TAG: "14.6.0", AWS_PROFILE: "custom-profile", AWS_REGION: "us-east-1")
//         }
//     }
// }
// must pass region otherwise this function will take N.virginia(us-east-1) as default region

def call(Map map) 
{
    sh """
    `aws ecr get-login --no-include-email --region ${map.AWS_REGION ?: 'us-east-1'} --profile ${map.AWS_PROFILE ?: 'default'}`
    docker push ${map.IMAGE_NAME}:${map.IMAGE_TAG}
    """
}