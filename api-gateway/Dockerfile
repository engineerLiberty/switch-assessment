FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/api-service.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-service.jar"]