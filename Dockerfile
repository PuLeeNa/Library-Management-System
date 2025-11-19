# Build stage - using Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Runtime stage - also using Java 21
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /app/target/LibManagement-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]