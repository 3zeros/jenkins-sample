pipeline {
    agent any
    stages {
        stage('create file') {
            step {
                writeFile(file: "${FILE_NAME}_txt", text: "${OUTPUT_TEXT}")
                sh 'ls -la'
                echo 'it is one of the benefits when using pipeline'
                sh "cat ${FILE_NAME}.txt"
            }
        
        }
    }
}