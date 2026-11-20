
pipeline {
    agent any

    tools {
        jdk 'JDK 25'
        maven 'Maven-3.9.16'
    }

    stages {

        stage('SCM Synchronization') {
            steps {
                echo 'Checking out latest GitHub code...'
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
                echo 'Compiling Java and running JUnit tests...'
                bat 'mvn clean package'
            }
            post {
                always {
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
                echo 'Building Calculator Docker image...'
                bat 'docker build -t simple-calculator:1.0 .'
            }
        }

        stage('Docker Container Execution') {
            steps {
                echo 'Running Calculator Docker container...'
                bat 'docker run --rm simple-calculator:1.0'
            }
        }
    }

    post {
        success {
            echo 'Maven, JUnit, SonarQube and Docker completed successfully!'
        }

        failure {
            echo 'Pipeline failed. Check the failed stage in Console Output.'
        }
    }
}
