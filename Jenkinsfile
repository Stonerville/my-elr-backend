pipeline {
  agent {
    docker {
      image 'maven:3.3.3'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('Clone Repository') {
      steps {
        checkout scm
      }
    }
    stage('Build') {
      steps {
        checkout scm
        sh 'mvn -B -DskipTests clean package'
      }
    }
    stage('Test') {
      post {
        always {
          junit 'target/surefire-reports/*.xml'

        }

      }
      steps {
        sh 'mvn test'
      }
    }
    stage('Deliver') {
      steps {
        sh 'jenkins/deliver.sh'
      }
    }
  }
}