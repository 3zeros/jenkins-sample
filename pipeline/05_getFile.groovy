pipeline {
    agent any
    parameters {
        string(
            name: 'COPY_SOURCE_PROJECT',
            defaultValue: "PIpelineTest04",
            description: 'Name of source project for copying of artifacts.'
        )
    }
    stages{
        stage ('delete workspace'){
            steps {
                deleteDir()
            }
        }
        stage('copy artifacts'){
            steps{
                copyArtifacts(projectName: "${param.COPY_SOURCE_PROJECT}")
            }
        }
        stage('find files'){
            steps{
                script {
                    files = findFiles(glob: '*.*')
                    for (file in files) {
                        echo file.name
                    }
                }
            }
        }
    }
}