#!/user/bin/env groovy

import com.example.Docker

def call(String imageNmae) {
    echo "Before calling buildDockerImage class function"
    return new Docker(this).buildDockerImage(imageName)
}
