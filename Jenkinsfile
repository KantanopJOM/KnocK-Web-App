pipeline {
     agent any
     stages {
          stage('Source') {
               steps {
                    git branch: 'main',
                        url: 'https://github.com/KantanopJOM/KnocK-Web-App.git'
               }
          }
          stage('Build') {
               steps {
                    bat 'mvn package -DskipTests'
               }
          }
          stage('Test') {
               steps {
                    echo 'testing...'
                    //bat 'mvn test'
               }
          }
          stage('Deploy') {
               steps {
                    bat 'java -jar ./target/demo-0.0.1-SNAPSHOT.jar'
               }
          }
     }
}
