pipeline {
    agent any
    parameters {
        string (
            name: 'Step_01',
            defaultValue: "pipelineTest01"
        )
        string (
            name: 'Step_02',
            defaultValue: "pipelineTest02"
        )
        string (
            name: 'Step_03',
            defaultValue: "pipelineTest03"
        )
    }
    stages{
        stage('parallel build'){
            steps{
                parallel(
                    "First_step": {
                        echo "${params.Step_01}"
                        build "${params.Step_01}"
                    },
                    "Second_step": {
                        echo "${params.Step_02}"
                        build "${params.Step_02}"
                    },
                    "Third_step": {
                        echo "${params.Step_03}"
                        build (
                            job: "${params.Step_03}",
                            parameters: [
                                text(name: 'FILE_NAME', value: 'created_06_build'),
                                text(name: 'OUTPUT_TEXT', value: 'created_06_content'),
                            ]
                        )
                    }
                )

            }
        }
    }
}