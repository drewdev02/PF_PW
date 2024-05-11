# Use the official Maven image to build the project
FROM maven:3.9.4-amazoncorretto-20-al2023 AS build

# Copy the pom.xml file to the container
COPY pom.xml .

# Download the project dependencies
RUN mvn dependency:go-offline

# Copy the rest of the source code to the container
COPY src/ src/

# Build the project
RUN mvn package -DskipTests

# Use a smaller base image to run the application
FROM openjdk:20-jdk-oraclelinux7

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file to the container
COPY --from=build target/PF-0.0.1-SNAPSHOT.jar .

# Expose the port that the application will be listening on
EXPOSE 8080

# Start the application when the container starts
CMD ["java", "-jar", "PF-0.0.1-SNAPSHOT.jar"]