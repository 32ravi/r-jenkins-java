pipeline {
    agent any

    parameters {
         string(name: 'tomcat_dev', defaultValue: 'ravi-vm', description: 'Staging Server')
         //string(name: 'tomcat_prod', defaultValue: '107.22.144.57', description: 'Production Server')
    }

    triggers {
         pollSCM('1 1 * * *')
     }

stages{
        stage('Build'){
            steps {
                sh 'mvn clean package'
                sh " build done"
                sh "docker build . -t ravijavadocker:${env.BUILD_ID}"
                sh "echo ${my_tag}"
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: 'target/*.jar'
                }
            }
        }

        stage ('Deployments'){
            parallel{
                stage ('Deploy to Staging'){
                    steps {
                        sh "pwd ; id"

                         sh "cp target/*.jar /home/ravin/jenkins-sandbox"

                        sh "java -classpath /home/ravin/jenkins-sandbox/*.jar jenkinsjob"

                    }
                }

                /*stage ("Deploy to Production"){
                    steps {
                        sh "echo "
                    }
                }*/
            }
        }
    }
}
