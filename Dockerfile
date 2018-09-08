FROM openjdk:7
COPY ./target/*.jar /usr/lib/myapp.jar

CMD ["java", "-classpath /usr/lib/*.jar jenkinsjob"]
