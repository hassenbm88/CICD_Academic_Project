pipeline{
    agent any
    tools {
        maven 'MAVEN'
    }
    stages {
        stage('Getting project from Git') {
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], browser: [$class: 'GithubWeb', repoUrl: 'https://github.com/hassenbm88/CICD_Academic_Project.git'], extensions: [], userRemoteConfigs: [[credentialsId: '18558545-93a9-448f-bf74-85184c601676', url: 'https://github.com/hassenbm88/CICD_Academic_Project.git']]])
            }
        }
        
        
        stage('Cleaning the project') {
            steps{
                sh "mvn -B -DskipTests clean  " 
            }
        }
        
        
        stage('Unit Tests') {
            steps{
                sh "mvn test " 
            }
        }
        
        
        
        stage('Artifact Construction') {
            steps{
                sh "mvn -B -DskipTests package " 
            }
        }
        
         
        
     
        stage('Code Quality Check via SonarQube') {
            steps{
                
             sh " mvn sonar:sonar -Dsonar.projectKey=CICD_Academic_Project -Dsonar.host.url=http://localhost:9000 -Dsonar.login=5f74b4c464cd1ad62d859b40eb6c42eda392d71e"
 
            }
        }
        

      
        stage('Publish to Nexus') {
            steps {
                script {
                    
configFileProvider([configFile(fileId: 'maven-settings', variable: 'settings')]) {
  sh 'mvn  -B -DskipTests deploy -s $settings'}
                
                }
            }
        }
          stage('Build Docker Image') {
                      steps {
                          script {
                            sh 'docker build -t hsounabm/spring-app .'
                          }
                      }
                  }
                  stage('Push Docker Image') {
                      steps {
                          script {
                           withCredentials([string(credentialsId: 'hsounabm', variable: 'dockerhubpwd')]) {
                              sh 'docker login -u hsounabm -p ${dockerhubpwd}'
                           }
                           sh 'docker push hsounabm/spring-app'
                          }
                      }
                  }
        
        
        stage('Run Spring && MySQL Containers') {
                      steps {
                          script {
                            sh 'docker-compose up -d'
                          }
                      }
                  }
            
        
        
} 
    
   
}
       
