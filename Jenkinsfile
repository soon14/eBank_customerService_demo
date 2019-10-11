node('java') {
    def MVN = tool('M3') + '/bin/mvn'
//
    stage('compile') {
        sh "${MVN} compile"
    }

    stage('sonar') {
        withSonarQubeEnv('LocalSonarqube') {
            sh "${tool 'LocalScanner'}/bin/sonar-scanner"
        }
    }
}
