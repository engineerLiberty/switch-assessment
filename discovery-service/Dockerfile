FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/discovery-service.jar .
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "discovery-service.jar"]