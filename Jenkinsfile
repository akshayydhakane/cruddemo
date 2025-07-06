pipeline {
    agent any
    
    triggers {
        githubPush()
    }
    
    stages {
        stage('Clone Repository') {
            steps {
                git url: 'https://github.com/akshayydhakane/cruddemo.git'
            }
        }

        stage('Build Java Application') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build and Deploy with Docker Compose') {
            steps {
                sh '''
                    docker compose -f /home/cruddemo/docker-compose.yaml down || true
                    docker compose -f /home/cruddemo/docker-compose.yaml up --build -d
                '''
            }
        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed!'
        }
    }
}
