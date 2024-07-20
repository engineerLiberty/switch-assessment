FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/auth-service.jar .
EXPOSE 8094
ENTRYPOINT ["java", "-jar", "auth-service.jar"]