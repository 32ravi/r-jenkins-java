FROM openjdk:7
ADD ./target/*.jar /usr/src/myapp

CMD ["java", "-classpath /usr/src/myapp/*.jar jenkinsjob"]
