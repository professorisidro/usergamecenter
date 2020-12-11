
pipeline {
   agent any
   tools {
       maven 'maven-3.6'
       jdk 'jdk-11'
       git 'git-default'
   }
   stages{
      stage ('Initialize'){
         steps {
            echo '**** INICIALIZANDO ROTINA DE BUILD AUTOMATICO - BY PROFESSOR ISIDRO ****'
         }
      }
      stage ('GIT Checkout'){
         steps {
            sh 'rm -Rf testador/'
            sh 'git clone https://github.com/professorisidro/testador'
         }
      }
      stage ('Test'){
         steps{
            sh 'mvn test'
         }
      }
      stage ('Build'){
         steps {
            sh 'mvn clean package'
         }
      }
      stage ('Deploy'){
      	steps{
      	   sh './deploy.sh'
      	}
      }
   }
}
