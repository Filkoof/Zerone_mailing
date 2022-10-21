FROM openjdk:17-slim
ADD target/ZeroneMailingMicroservice-0.0.1-SNAPSHOT.jar zerone-mailing.jar
ENTRYPOINT ["java", "-jar", "zerone-mailing.jar"]