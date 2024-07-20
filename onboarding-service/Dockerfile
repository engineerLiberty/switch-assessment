FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/onboarding-service.jar .
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "onboarding-service.jar"]