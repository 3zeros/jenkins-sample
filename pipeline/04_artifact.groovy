pipeline {
    agent any
    environment {
        fileName1 = "${FILE_NAME}.txt"
        fileName2 = "AnotherFile.txt"
        contextOfFile2 = "Here is file2"
    }
    stages {
        stage('create file') {
            steps {
                echo 'create file 1,2'
                writeFile(file: fileName1, text: "${OUTPUT_TEXT}")
                writeFile(file: fileName2, text: contextOfFile2)
            }
        }
        stage('archive artifacts'){
            steps {
                echo 'save file 1, 2'
                archiveArtifacts fileName1
                archiveArtifacts fileName2
            }
        }
    }
    // post {
    //     success {
    //         cleanWs()
    //     }
    // }
}