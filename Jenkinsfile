pipeline {
    agent none 
    //agent DOCKER1  
    stages {        
        stage('Build Jar') {            
            agent {     
                docker {
                        image 'maven:3-alpine'
                        args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests'
            }            
        }
        stage('Build Image') {
            steps {
                script {
                    app= docker.build("aadithyaks/selenium-docker")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhublogin') 
                    {
                        app.push("${BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }
    }
}