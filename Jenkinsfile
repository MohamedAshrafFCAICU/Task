pipeline {
    agent any
    
    tools {
        maven 'Maven3'  
        jdk 'JDK21'     
    }
    
    environment {
        PROJECT_NAME = 'Calculator Project'
    }
    
    options {
        timestamps()
        timeout(time: 30, unit: 'MINUTES')
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }
    
    stages {
        
        stage('Checkout') {
            steps {
                echo '=========================================='
                echo 'STAGE 1: Checking out code from Git...'
                echo '=========================================='
                
                cleanWs()
                
                git branch: 'master',
                    url: 'https://github.com/MohamedAshrafFCAICU/Task.git'
                
                echo 'Code checkout completed successfully!'
            }
        }
        
        stage('Build') {
            steps {
                echo '=========================================='
                echo 'STAGE 2: Building the project...'
                echo '=========================================='
                
                bat 'mvn clean compile'
                
                echo 'Build completed successfully!'
            }
        }
        
        stage('Test') {
            steps {
                echo '=========================================='
                echo 'STAGE 3: Running Unit Tests...'
                echo '=========================================='
                
                bat 'mvn test'
                
                echo 'All tests executed!'
            }
            post {
                always {
                    junit allowEmptyResults: true, 
                          testResults: '**/target/surefire-reports/*.xml'
                    
                    echo 'Test results published!'
                }
                success {
                    echo 'All tests passed successfully!'
                }
                failure {
                    echo 'Some tests failed. Check the report for details.'
                }
            }
        }
        
        stage('Package') {
            steps {
                echo '=========================================='
                echo 'STAGE 4: Packaging the application...'
                echo '=========================================='
                
                bat 'mvn package -DskipTests'
                
                archiveArtifacts artifacts: 'target/*.jar', 
                                 fingerprint: true,
                                 allowEmptyArchive: true
                
                echo 'Application packaged successfully!'
            }
        }
        
        stage('Build Summary') {
            steps {
                echo '=========================================='
                echo 'STAGE 5: Build Summary'
                echo '=========================================='
                echo "Project: ${PROJECT_NAME}"
                echo "Build Number: ${BUILD_NUMBER}"
                echo "Build Status: SUCCESS"
                echo '=========================================='
            }
        }
    }
    
    post {
        always {
            echo '=========================================='
            echo 'Pipeline execution completed!'
            echo '=========================================='
        }
        success {
            echo 'BUILD SUCCESSFUL! All stages completed without errors.'
        }
        failure {
            echo 'BUILD FAILED! Check the logs for details.'
        }
        cleanup {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
    }
}