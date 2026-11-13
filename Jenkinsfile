<<<<<<< HEAD
pipeline {
    agent any
    
    
    // Use tools Name configured in Jenkins
    tools {
        jdk 'JDK 25'
        maven 'Maven-3.10'
    }


    stages {
        stage('SCM Synchronization') {
            steps {
                echo '📥 Pulling latest code changes from Git repository...'
=======

pipeline {

    agent any

    stages {

        stage('SCM Synchronization') {
            steps {
                echo 'Pulling latest code changes from Git repository...'

>>>>>>> ffa35bb85d574d5d70560d8f68eaeea77a6ee381
                checkout scm
            }
        }

        stage('Static Verification') {
            steps {
<<<<<<< HEAD
                echo '🔍 Checking Maven project layout rules...'
=======
                echo 'Checking Maven project layout rules...'

>>>>>>> ffa35bb85d574d5d70560d8f68eaeea77a6ee381
                bat 'mvn validate'
            }
        }

        stage('Compilation & Automated Testing') {
            steps {
<<<<<<< HEAD
                echo '⚙️ Compiling class layers and verifying test logic stability...'
                bat 'mvn clean package'
            }
            post {
                always {
                    echo '📊 Publishing Unit Test trends to Jenkins Dashboard...'
=======
                echo 'Compiling class layers and verifying test logic stability...'

                bat 'mvn clean package'
            }

            post {
                always {
                    echo 'Publishing Unit Test trends to Jenkins Dashboard...'

>>>>>>> ffa35bb85d574d5d70560d8f68eaeea77a6ee381
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
<<<<<<< HEAD
        success {
            echo '✅ CI Pipeline completed flawlessly! Code stability confirmed.'
        }
        failure {
            echo '❌ CI Pipeline broken. Check console logs for build failures or breaking test regressions.'
=======

        success {
            echo 'CI Pipeline completed flawlessly! Code stability confirmed.'
        }

        failure {
            echo 'CI Pipeline broken. Check console logs for build failures or test regressions.'
>>>>>>> ffa35bb85d574d5d70560d8f68eaeea77a6ee381
        }
    }
}
