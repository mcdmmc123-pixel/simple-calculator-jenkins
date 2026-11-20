
pipeline {
    agent any

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
                echo 'Compiling Java code and running JUnit tests...'
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
    }

    post {
        success {
            echo 'CI Pipeline completed successfully!'
        }

        failure {
            echo 'CI Pipeline failed. Check Console Output.'
        }
    }
}
