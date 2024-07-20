# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the executable jar file
COPY target/config-server.jar .

# Expose the port the application runs on
EXPOSE 8888

# Run the jar file
ENTRYPOINT ["java", "-jar", "config-server.jar"]