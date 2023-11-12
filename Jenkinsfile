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
            // when {
            //     // execute this stage only if the previous stages were successful
            //     expression { BRANCH_NAME == 'master'}
            // } 
            // print the branch name
            steps {
                echo "Deploying branch ${BRANCH_NAME}"
                withCredentials([usernamePassword(credentialsId: '245fadd9-9fc2-4ee1-9868-20269bc04ed4', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    // Use the USERNAME and PASSWORD variables in a secure way
                    // For example, to authenticate with a server
                    // sh "some-command --user ${USERNAME} --password ${PASSWORD}"
                    echo "Username: ${USERNAME}"
                }
            }
        }
    }
    post {
        always {
            // always execute this block
            // e.g. send email to team
            echo 'Sending email to team...'
        }
        success {
            // execute this block only if the stage was successful
            echo 'success'
        }
        failure {
            // execute this block only if the stage was failed
            echo 'failure'
        }
    } // post attribute executes logic after the pipeline is done
}
