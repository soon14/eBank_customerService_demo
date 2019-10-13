node('java') {
//    def MVN = tool('M3') + '/bin/mvn'

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

    stage('lean env') {
        echo 'BUILD_ID' + env.BUILD_ID
        echo 'BUILD_NUMBER' + env.BUILD_NUMBER
        echo 'BUILD_URL' + env.BUILD_URL
        echo 'EXECUTOR_NUMBER' + env.EXECUTOR_NUMBER
        echo 'JOB_NAME' + env.JOB_NAME
        echo 'NODE_NAME:' + env.NODE_NAME
        echo 'CHANGE_TITLE:' + env.CHANGE_TITLE
        echo 'CHANGE_AUTHOR:' + env.CHANGE_AUTHOR
    }

    stage('define env') {
        def A = '---------------------'
        env.OUTER = '9999'
        withEnv(["INNER = 88888"]) {}
        sh 'printenv'
    }
    stage('test evn cross stage') {
        sh 'printenv'
    }
}


