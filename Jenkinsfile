pipeline {
    agent any
    def a = 'aa'
    stages {
        stage('build') {
            steps{
                sh "${tool 'M3'}/bin/mvn -version"
                echo a
            }

        }
    }

}