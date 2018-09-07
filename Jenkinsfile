pipeline {
    agent any

    parameters {
         string(name: 'tomcat_dev', defaultValue: 'ravi-vm', description: 'Staging Server')
         #string(name: 'tomcat_prod', defaultValue: '107.22.144.57', description: 'Production Server')
    }

    triggers {
         pollSCM('* * * * *')
     }

stages{
        stage('Build'){
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: './target/*.jar'
                }
            }
        }

        stage ('Deployments'){
            parallel{
                stage ('Deploy to Staging'){
                    steps {
                        sh "cp -i /home/ravin/aws/RaviACG.pem -o StrictHostKeyChecking=no **/target/*.war ec2-user@${params.tomcat_dev}:/var/lib/tomcat/webapps"
                        sh "pwd ; id"

                        sh "cp target/*.jar /home/ravin/jenkins-sandbox"

                        sh "java -classpath /home/ravin/jenkins-sandbox/*.jar jenkinsjob"

                    }
                }

                stage ("Deploy to Production"){
                    steps {
                        sh "echo "
                    }
                }
            }
        }
    }
}
