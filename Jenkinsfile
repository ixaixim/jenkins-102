pipeline {
    agent any
    parameters {
        // string(name: 'VERSION', defaultValue: '', description: 'Version to deploy')
        choice(name: 'VERSION', choices: ['1.0', '1.1', '1.2'], description: 'Version to deploy')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'Enable debug mode')
    }
    environment {
        // define environment variables here
        // e.g. AWS_ACCESS_KEY_ID = credentials('aws-access-key-id')
        NEW_VERSION = sh(script: 'echo $BUILD_NUMBER', returnStdout: true).trim()
        // SERVER_CREDENTIALS = credentials('server-credentials') // define credentials here, needs credentials plugin
    }
    // tools {
    //     // define tools here
    //     // e.g. maven 'maven-3.6.3', jdk 'jdk-11', gradle 'gradle-6.7.1'
    //     maven 'Maven 3.6.3'
    // }
    stages {
        stage('Init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }
        stage('Build') {
            steps {
                gv.buildApp()
                echo "Building version ${NEW_VERSION}" // use environment variable within DOUBLE quotes!
                 
            }
        }
        stage('Test') {
            when {
                expression { params.executeTests == true }
            }
            steps {
                gv.testApp()
                // Test your code here
            }
        }
        stage('Deploy') {
            steps {
                gv.deployApp()
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
