pipeline {
    agent any
    stages {
        stage('test1: Using when_01'){
            when{branch 'master'}
            steps {
                echo 'it is executed'
            }
        }
        stage('test2: using when_02'){
            when{not{branch 'master'}}
            steps {
                echo 'it is not executed'
            }
        }
        stage('test3: using script'){
            steps{
                script{
                    if (env.BRANCH_NAME =='master'){
                        for (i in 1 ..5) {
                            echo 'I only execute on the master branch'
                        }
                    } else {
                        echo 'i execute elsewhere'
                    }
                }
            }
        }
    }
}