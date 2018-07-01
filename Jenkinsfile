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
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') {
            steps {
                sh 'bash ./jenkins/deliver.sh'
            }
        }
    }
}