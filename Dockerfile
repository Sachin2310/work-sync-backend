# Use an official image
FROM amazoncorretto:17-alpine-jdk

# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY build/libs/worksync-app.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
