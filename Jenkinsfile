pipeline {
    agent any
    environment {
        // define environment variables here
        // e.g. AWS_ACCESS_KEY_ID = credentials('aws-access-key-id')
        NEW_VERSION = sh(script: 'echo $BUILD_NUMBER', returnStdout: true).trim()
        // SERVER_CREDENTIALS = credentials('server-credentials') // define credentials here, needs credentials plugin
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                echo "Building version ${NEW_VERSION}" // use environment variable within DOUBLE quotes!
                 
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                // Test your code here
            }
        }
        stage('Deploy') {
            when {
                // execute this stage only if the previous stages were successful
                // expression { BRANCH_NAME == 'master'}
            }
            steps {
                echo 'Deploying...'
                withCredentials([usernamePassword(credentialsId: 'server-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh "echo ${USERNAME} ${PASSWORD}" 
                } // example how to use credentials

                // Deploy your code here
            }
        }
    }
    post {
        always {
            // always execute this block
            // e.g. send email to team
        }
        success {
            // execute this block only if the stage was successful
        }
        failure {
            // execute this block only if the stage was failed
        }
    } // post attribute executes logic after the pipeline is done
}
