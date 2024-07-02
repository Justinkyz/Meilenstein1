# Use the Gradle image to build the project
FROM gradle:8-jdk21 as builder
WORKDIR /app
COPY . .
RUN gradle build

# Use the OpenJDK image to run the application
FROM openjdk:21-slim
LABEL authors="Justin Le, Chaemin Lim"

# Copy the built JAR file from the builder stage
COPY --from=builder /app/build/libs/Webtech-0.0.1-SNAPSHOT.jar /app/Webtech-0.0.1-SNAPSHOT.jar

# Set the working directory
WORKDIR /app

# Run the JAR file
ENTRYPOINT ["java", "-jar", "Webtech-0.0.1-SNAPSHOT.jar"]
