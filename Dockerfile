FROM openjdk:7
COPY /var/lib/jenkins/workspace/java-docker-project/target/*.jar /usr/lib

CMD ["java", "-classpath /usr/lib/*.jar jenkinsjob"]
