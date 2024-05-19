# Use a Java base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file from your build target to the container
COPY ./target/PlantAndPlanters-0.0.1-SNAPSHOT.jar .

# Expose the port that your Spring Boot application is listening on
EXPOSE 8085

# Command to run the Spring Boot application
CMD ["java", "-jar", "PlantAndPlanters-0.0.1-SNAPSHOT.jar"]