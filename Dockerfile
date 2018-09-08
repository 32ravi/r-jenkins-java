FROM openjdk:7
COPY ./target/*.jar /usr/lib/myapp.jar
WORKDIR /usr/lib
CMD ["java", "-classpath", "myapp.jar", jenkinsjob"]
