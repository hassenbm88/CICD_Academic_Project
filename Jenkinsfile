pipeline{
    agent any
    tools {
        maven 'M2_HOME'
    }
    stages {
        stage('Getting project from Git') {
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/yassine']], browser: [$class: 'GithubWeb', repoUrl: 'https://github.com/hassenbm88/CICD_Academic_Project.git'], extensions: [], userRemoteConfigs: [[credentialsId: '18558545-93a9-448f-bf74-85184c601676', url: 'https://github.com/hassenbm88/CICD_Academic_Project.git']]])
            }
        }
        
        
        stage('Cleaning the project') {
            steps{
                sh "mvn -B -DskipTests clean  " 
            }
        }
                stage('Cleaning versiont') {
            steps{
                sh "mvn --version  " 
            }
        }
        
        
        
        stage('Artifact Construction') {
            steps{
                sh "mvn -B -DskipTests package " 
            }
        }
        
         stage('Unit Tests') {
            steps{
                sh "mvn test " 
            }
        }
         stage('Code Quality Check via SonarQube') {
            steps{
                
             sh "mvn sonar:sonar -Dsonar.projectKey=sonar -Dsonar.host.url=http://172.10.0.140:9000  -Dsonar.login=9b6c18f90f2ca130b791ddcad247f419cc4ec5f8"
               
            }
        }
        stage('nexsu'){
           steps{
               script{
                    configFileProvider([configFile(fileId: '729fcc5d-5f72-4798-afba-d14f27521721', variable: 'yassine')]) 
              {sh 'mvn  -B -DskipTests deploy -s $yassine'
              }}
           }}
       
        
       
} 
    stage('Build Docker Image') {
                      steps {
                          script {
                            sh 'docker build -t yassinedockeer/spring-app .'
                          }
                      }
                  }
                  stage('Push Docker Image') {
                      steps {
                          script {
                           withCredentials([usernameColonPassword(credentialsId: '5f85e097-f908-41d0-8131-613cac0adb04', variable: 'var')]) {
                              sh 'docker login -u yassinedockeer -p ${var}'
                           }
                           sh 'docker push yassinedockeer/spring-app'
                          }
                      }
                  }
        
     post {
            always{
                
                
                emailext to: "yassine.bensalem@esprit.tn",
                subject: "jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}",
                    recipientProviders: [[$class: 'DevelopersRecipientProvider']]
                
                
            
            }
        }
     
}
       
