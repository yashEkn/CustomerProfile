pipeline {
  agent any
  
stages {
  stage('maven install') {
    steps {
      withMaven(maven: 'Maven1') {
        sh 'mvn clean install'
      }
    }
  }

}

}
