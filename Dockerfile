# Stage 1: Build the Java application
FROM maven:3.8.3-openjdk-17 as mavenOpenjdk17
WORKDIR /apps
COPY src src
COPY pom.xml .

RUN mvn -f pom.xml clean package

# Stage 2: Package the Java application
FROM openjdk:17.0.1-jdk-slim as OpenJdkSlim
COPY --from=mavenOpenjdk17 /apps/target/backend-0.0.1-SNAPSHOT.jar /usr/local/lib/backend.jar
ENTRYPOINT ["java", "-jar", "/usr/local/lib/backend.jar"]
    
EXPOSE 8080