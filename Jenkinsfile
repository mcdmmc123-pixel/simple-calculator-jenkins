
pipeline {
    agent any

    tools {
        jdk 'JDK 25'
        maven 'Maven-3.9.16'
    }

    stages {

        stage('SCM Synchronization') {
            steps {
                echo 'Pulling latest code from GitHub...'
                checkout scm
            }
        }

        stage('Static Verification') {
            steps {
                echo 'Validating Maven project...'
                bat 'mvn validate'
            }
        }

        stage('Compilation & Automated Testing') {
            steps {
                echo 'Compiling and running JUnit tests...'
                bat 'mvn clean package'
            }
            post {
                always {
                    echo 'Publishing JUnit test results...'
                    junit allowEmptyResults: true,
                          testResults: '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo 'Starting SonarQube analysis...'
                withSonarQubeEnv('SonarQube-Local') {
                    bat 'mvn sonar:sonar'
                }
            }
        }

        stage('Docker Image Build') {
            steps {
                echo 'Building Docker image...'
                bat 'docker build -t simple-calculator:1.0 .'
            }
        }

        stage('Docker Container Execution') {
            steps {
                echo 'Running Calculator inside Docker...'
                bat 'docker run --rm simple-calculator:1.0'
            }
        }
    }

    post {
        success {
            echo 'Build, Testing, SonarQube and Docker completed successfully!'
        }

        failure {
            echo 'Pipeline failed. Check Console Output.'
        }
    }
}
