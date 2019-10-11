pipeline {
    agent any
    stages {
        stage('build') {
            steps{
                sh "${tool 'M3'}/bin/mvn -version"
            }
        }
    }

}