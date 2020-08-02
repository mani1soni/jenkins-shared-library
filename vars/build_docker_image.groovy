#!/usr/bin/env groovy 
// Usage example
// stage('build-image'){
//     steps{
//         script{
//             build_docker_image (IMAGE_NAME: "node", IMAGE_TAG: "14.6.0", DOCKER_FILE: "deployment/custom-dockerfile", EXTRA_ARGS: "--build-arg DBUSERNAME=test --build-arg DBPASSWORD=test", ECHO: "off")
//         }
//     }
// }
// here we are passing db username password which should not be printed on jenkins console output so  to turn off echo we are using set +x and to turn on echo use set -x

def call (Map map) {
    sh """
    if [ "${map.ECHO}" == "off" ];then
        set +x
    fi
    if [ "${map.EXTRA_ARGS}" == "null" ];then
        docker build -t ${map.IMAGE_NAME}:${map.IMAGE_TAG ?: 'latest'} -f ${map.DOCKER_FILE ?: 'Dockerfile'} ${map.CONTEXT ?: '.'}
    else
        docker build ${map.EXTRA_ARGS} -t ${map.IMAGE_NAME}:${map.IMAGE_TAG ?: 'latest'} -f ${map.DOCKER_FILE ?: 'Dockerfile'} ${map.CONTEXT ?: '.'}
    fi
    """
}