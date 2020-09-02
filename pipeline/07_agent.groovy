pipeline {
    agent none
    stages {
        stage('Run Tests') {
            parallel {
                stage('Test On Agent') {
                    agent {
                        label "${AGENT_NAME}"
                    }
                    steps {
                        sh 'pwd'
                    }
                }
                stage('Test On Master') {
                    steps {
                        sh 'pwd'
                    }
                }
            }
        }
    }
}