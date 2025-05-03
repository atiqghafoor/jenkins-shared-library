#!/user/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){    
        sh 'docker build -t 137.202.47.31:8083/demo-app:jma-3.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin 137.202.47.31:8083'
        sh 'docker push 137.202.47.31:8083/demo-app:jma-3.0'
    }
}
