FROM maven:3.9-eclipse-temurin-21-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /target/gurpswm-0.0.1-SNAPSHOT.jar gurpswm.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gurpswm.jar"]