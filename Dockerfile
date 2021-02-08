FROM openjdk:latest
COPY ./target/SEM-Group19-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SEM-Group19-0.1.0.1-jar-with-dependencies.jar"]