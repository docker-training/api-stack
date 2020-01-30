pipeline {    

    agent any    
    
    environment {
        DOCKER_TLS_VERIFY='1'                                                                                               
        COMPOSE_TLS_VERSION='TLSv1_2'                                                                                       
        DOCKER_CERT_PATH='/home/jenkins/jenkinscerts'
        DOCKER_HOST='tcp://<UCP FQDN>:443'
        DTR_FQDN_PORT='<DTR_FQDN>:4443'
    }

    stages {
        stage('Build') {
            environment {
                DTR_ACCESS_KEY = credentials('jenkins-dtr-access-token')
		MAJORMINOR = '0.0'
            }
            steps {
                sh 'docker image build -t ${DTR_FQDN_PORT}/engineering/api-build:rc-${MAJORMINOR}.${BUILD_ID} api'
                sh 'docker image build --target test -t ${DTR_FQDN_PORT}/engineering/api-build:unittest-${MAJORMINOR}.${BUILD_ID} api'
                sh 'docker login -u jenkins -p ${DTR_ACCESS_KEY} ${DTR_FQDN_PORT}'
                sh 'docker image push ${DTR_FQDN_PORT}/engineering/api-build:rc-${MAJORMINOR}.${BUILD_ID}'
                sh 'docker image push ${DTR_FQDN_PORT}/engineering/api-build:unittest-${MAJORMINOR}.${BUILD_ID}'
            }
        }
    }
    
    post {
        always{
	        sh 'rm -rf ${WORKSPACE}/*'
        }
    }
}
