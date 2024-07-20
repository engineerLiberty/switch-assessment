FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/billing-service.jar .
EXPOSE 8095
ENTRYPOINT ["java", "-jar", "billing-service.jar"]