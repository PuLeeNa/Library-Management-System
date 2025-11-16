FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Use one of these instead of openjdk:17-jdk-slim
# FROM openjdk:17-slim
# OR
FROM eclipse-temurin:17-jre
# OR
# FROM openjdk:17-jre-slim

WORKDIR /app

COPY --from=build /app/target/LibManagement-0.0.1-SNAPSHOT.jar .

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "LibManagement-0.0.1-SNAPSHOT.jar"]