## Use an official OpenJDK runtime as a parent image
#FROM openjdk:17-jdk-slim
#
## Set the working directory in the container
#WORKDIR /app
#
## Copy the project's JAR file into the container at /app
#COPY target/sample-app.jar /app/app.jar
#
## Make port 8080 available to the world outside this container
#EXPOSE 8080
#
## Run the JAR file
#ENTRYPOINT ["java", "-jar", "app.jar"]

# Use a Maven image as the base for the build stage
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

# Use a lightweight Java runtime image for the final stage
FROM openjdk:17-jre-slim
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
