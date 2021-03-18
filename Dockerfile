FROM openjdk:latest
COPY ./target/GroupProject.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "GroupProject.jar", "db:3306"]