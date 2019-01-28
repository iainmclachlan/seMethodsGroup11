FROM openjdk:latest
COPY ./target/seMethodsGroup11-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethodsGroup11-0.1.0.1-jar-with-dependencies.jar"]