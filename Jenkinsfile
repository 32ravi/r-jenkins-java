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
                    }
                }

                stage ("Deploy to Production"){
                    steps {
                        sh "scp -i /home/ravin/aws/RaviACG.pem -o StrictHostKeyChecking=no **/target/*.war ec2-user@${params.tomcat_prod}:/var/lib/tomcat/webapps"
                    }
                }
            }
        }
    }
}
