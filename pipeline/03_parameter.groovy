pipeline {
    agent any
    stages {
        stage('create file') {
            steps {
                writeFile(file: "${FILE_NAME}.txt", text: "${OUTPUT_TEXT}")
                sh 'ls -la'
                echo 'it is one of the benefits when using pipeline'
                sh "cat ${FILE_NAME}.txt"
            }
        
        }
    }
}