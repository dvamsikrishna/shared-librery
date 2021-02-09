  
#!/usr/bin/env groovy

def call(String mavenversion, String jdkversion) {
echo 'Calling Jenkins file'
pipeline {
    agent any
    tools {
        maven "${mavenversion}"
        jdk 'jdkversion'
    }
    stages {
        stage('Maven-Build') {
            steps {
                echo "calling the mvnbuild.groovy function for mvn build"
                mvnbuild "mavenbuild"
            }
            
        }
        stage('Gitclone') {
            steps {
                echo "calling gitclone.groovy function for clone the gir reposiroty"
                gitclone ("https://github.com/dvamsikrishna/Sample-development.git","npm-shared-lib")
               
            }
            
}
    stage('NPM-Build') {
            steps {
                echo "calling npmbuild.groovy function for npm build"
                npmbuild("gitclone")
            }

}
    stage('Email') {
            steps {
                echo "calling email.groovy shared library function for sending an email"
                 email()
            }
}
}
}
}