#!/user/bin/env groovy

def call(String imageNmae) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){    
        sh "docker build -t $imageNmae ."
        sh 'echo $PASS | docker login -u $USER --password-stdin 137.202.47.31:8083'
        sh "docker push $imageNmae"
    }
}
