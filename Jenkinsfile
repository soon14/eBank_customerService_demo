node('java') {
    def MVN = tool('M3') + '/bin/mvn'

//    stage('check SCM'){
//        git 'file:///Users/ygdong/git/customer_service'
//    }
//
//    stage('compile') {
//        sh "${MVN} compile"
//    }
//
//    stage('sonar') {
//        withSonarQubeEnv('LocalSonarqube') {
//            sh "${tool 'LocalScanner'}/bin/sonar-scanner"
//        }
//    }
//
//    stage('quality gate'){
//        timeout(time:5,unit:'MINUTES'){
//            def qg = waitForQualityGate()
//            if (qg.status!='OK'){
//                error '质量门失败：'+qg.status
//            }
//        }
//    }

    stage('lean env'){
        echo env.BUILD_TAG
    }
}
