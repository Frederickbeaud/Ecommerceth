pipeline{
    agent any
    tools{
        maven 'maven3'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Frederickbeaud/Ecommerceth']])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t frederick123/ecommerceth .'
                }
            }
        }
        stage('Push image to hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u frederick123 -p ${dockerhubpwd}'

                   sh 'docker push frederick123/ecommerceth'
                   }
                }
            }

        }
        stage('Docker Deployement To Container'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u frederick123 -p ${dockerhubpwd}'

                   sh 'docker run -d --name ecommth -p 8081:8081 frederick123/ecommerceth:latest'
                   }
                }
            }

        }
    }
}