pipeline {
    agent any
    stages {
        stage('get current date') {
            steps {
                script {
                    script{
                        sh "curl -f -o data.json ${JSON_URL}"
                        json = readJSON file:'data.json'
                        echo "${json.date}"
                    }
                }
            }
        }
    }
}