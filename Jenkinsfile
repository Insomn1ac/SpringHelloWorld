pipeline {
  agent {
    label 'linux'
  }
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  triggers {
    pollSCM('* * * * *')
  }

  environment {
    HEROKU_API_KEY = credentials('insomn1ac-api-key')
  }
 
  stages {
    stage('Build') {
      steps {
        sh 'docker build -t insomn1ac/spring-hello-world:latest .'
      }
    }
    stage('Login') {
      steps {
        sh 'echo $HEROKU_API_KEY | docker login --username=_ --password-stdin registry.heroku.com'
      }
    }
    stage('Push to Heroku registry') {
      steps {
        sh '''
          docker tag insomn1ac/spring-hello-world:latest registry.heroku.com/testsupermegagiperhelloworld/web
          docker push registry.heroku.com/testsupermegagiperhelloworld/web
        '''
      }
    }
    stage('Release the image') {
      steps {
        sh 'heroku container:release web --app=testsupermegagiperhelloworld'
      }
    }
  }
  post {
    always {
      sh 'docker logout'
    }
  }
}
