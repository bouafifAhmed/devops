pipeline {
agent any

```
environment {
    DOCKERHUB_USER = "bouafifahmed"
    DOCKERHUB_REPO = "devops"
    IMAGE_TAG = "latest"
}

triggers {
    githubPush()
}

stages {

    stage('Checkout') {
        steps {
            checkout scm
        }
    }

    stage('Build Maven') {
        steps {
            sh "mvn clean package -DskipTests"
        }
    }

    stage('Build Docker Image') {
        steps {
            sh "docker build -t ${DOCKERHUB_USER}/${DOCKERHUB_REPO}:${IMAGE_TAG} ."
        }
    }

    stage('Docker Login & Push') {
        steps {
            withCredentials([usernamePassword(credentialsId: 'docker-file', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                sh "echo $PASS | docker login -u $USER --password-stdin"
                sh "docker push ${DOCKERHUB_USER}/${DOCKERHUB_REPO}:${IMAGE_TAG}"
            }
        }
    }
}

post {
    success {
        echo "🎉 Image envoyée avec succès sur Docker Hub : ${DOCKERHUB_USER}/${DOCKERHUB_REPO}:${IMAGE_TAG}"
    }
    failure {
        echo "❌ Le pipeline a échoué"
    }
}
```

}
