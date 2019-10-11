pipeline {
    agent any
    stages {
        stage('build') {
            steps{
                sh "${tool 'M3'}/bin/mvn -version"
            }
            post{
                success{
                    echo '-------------'
                }
                failure{
                    echo 'xxxxxxx'
                }
            }
        }
    }

}