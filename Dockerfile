FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/DermaCheck-0.0.1-SNAPSHOT.jar Dermacheck.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Dermacheck.jar"]