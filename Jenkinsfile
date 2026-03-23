pipeline {
    agent any

    tools {
        maven 'Maven_3.9.12'
    }

    environment {
        IMAGE_NAME = "nikstuff201/marketapp"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Check') {
            steps {
                sh 'mvn validate'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                recordCoverage(
                        tools: [
                                jacoco(pattern: '**/jacoco.xml')
                        ]
                )
            }
        }

            stage('Build Docker Image') {
                steps {
                    sh '''
                    export PATH=/usr/local/bin:/usr/bin:/bin
                    docker build -t $IMAGE_NAME:latest .
                '''
                }
            }

            stage('Push Docker Image to Docker Hub') {
                steps {
                    withCredentials([usernamePassword(
                            credentialsId: 'dockerId',
                            usernameVariable: 'DOCKER_USER',
                            passwordVariable: 'DOCKER_PASS'
                    )]) {

                        sh '''
                        export PATH=/usr/local/bin:/usr/bin:/bin
                        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                        docker push $IMAGE_NAME:latest
                    '''
                    }
                }
            }
        }
}
