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
            steps {
                echo 'Deploying...'
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
