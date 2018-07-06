pipeline {
                def shell_script = './jenkins/deliver.sh'
 agent {
        docker {
            image 'maven:3.3.3'
            args '-v /root/.m2:/root/.m2'
        }
    }    
    stages {
        stage('check env') {
            parallel {
                stage('check mvn') {
                    steps {
                        sh 'mvn -v'
                    }
                }
                stage('check java') {
                    steps {
                        sh 'java -version'
                    }
                }
            }
        }
       stage('Clone Repository') {
            steps {
                checkout scm
            }
        }
        stage('Code Review') {
            steps {
              withSonarQubeEnv('My SonarQube Server') {
                sh 'mvn sonar:sonar'
                }
            }
        }
        stage('Build') {
            steps {
                // sh 'mvn -B -DskipTests clean package'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
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
                 sh "chmod 0755 ${shell_script}"
                sh "bash ${shell_script}"
            }
        }
    }
}