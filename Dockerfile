FROM openjdk:latest
COPY  ./target/seMethodGroup11-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethodGroup11-0.1.0.2-jar-with-dependencies.jar"]