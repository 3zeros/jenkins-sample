pipeline {
    agent any
    stages {
        stage('execute ls command') {
            steps {
                echo 'execute ls command'
                sh 'ls -la'
            }
        }
        stage('Where do ls command execute?') {
            steps {
                echo 'Here is default.'
                sh 'ls -la'
                echo 'you can define where to execute command.'
                echo 'for ex, I want to view root directory'
                sh 'ls -la /'
            }
        }
        stage('Is there any other way?'){
            steps{
                echo 'Maybe sh is independent'
                sh 'cd /'
                sh 'pwd'
                sh 'ls -la'
                echo 'If you want to execute multiple commands in one sh.'
                sh '''cd /
                pwd
                ls -la'''
                
            }
        }
    }
}