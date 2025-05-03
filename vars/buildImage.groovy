#!/user/bin/env groovy

import com.example.Docker

def call(String imageNmae) {
    return new Docker(this).buildDockerImage(imageName)
}
