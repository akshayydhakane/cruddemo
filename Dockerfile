# Use the closest available official OpenJDK 17 image
FROM openjdk:17-jdk

# Set the working directory inside the container
WORKDIR /cruddemo

# Copy the jar file to the container
COPY target/cruddemo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application runs on
EXPOSE 8083

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
