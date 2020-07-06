def call() {
    pipeline{
        agent {
            node{
                label 'YOUR-NODE-NAME'
            }
        }
        environment{
            APP_PATH = 'APP-PATH'
        }
        stages{
            stage('old app backup'){
                steps{
                    sh '''
                    rm -rf ~/backup/APP-NAME/* && \
                    cp -r ${APP_PATH}/APP-NAME/* ~/backup/APP-NAME/.
                    '''
                }
            }
            stage('cleaning old code'){
                steps{
                    sh '''
                    rm -rf ${APP_PATH}/APP-NAME/* 
                    '''
                }
            }
            stage('build & deploy'){
                steps{
                    sh '''
                    cp -r * ${APP_PATH}/APP-NAME/. && \
                    cd ${APP_PATH}/APP-NAME/ && \
                    npm i
                    '''
                }
            }
            stage('pm2-service-start'){
                steps{
                    sh '''
                    pm2 start ecosystem.config.js
                    '''
                }
            }
        }
        post {
            success {
                emailext attachLog: true, 
                body: '''$DEFAULT_CONTENT''', 
                subject: '$DEFAULT_SUBJECT', 
                to: 'email@sampledomain.com'
            }
            failure {
                sh '''
                cp -r ~/backup/APP-NAME/*  ${APP_PATH}/APP-NAME/. && \
                cd ${APP_PATH}/APP-NAME/ && \
                pm2 start ecosystem.config.js
                '''
                emailext attachLog: true, body: '''$DEFAULT_CONTENT  test failed and rollback initiated''', subject: '$DEFAULT_SUBJECT', to: 'email@sampledomain.com'
            }
        }
    }
}