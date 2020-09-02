pipeline {
    agent none
    stages {
        stage('Run Tests') {
            parallel {
                stage('Test On Agent') {
                    agent {
                        label "${slave}"
                    }
                    steps {
                        sh 'pwd'
                    }
                }
                stage('Test On Master') {
                    agent any
                    steps {
                        sh 'pwd'
                    }
                }
            }
        }
    }
}