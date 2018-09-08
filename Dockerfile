FROM openjdk:7
ADD ./target/*.jar /usr/src/myapp

CMD ["java", "classpath /home/ravin/jenkins-sandbox/*.jar jenkinsjob"]
