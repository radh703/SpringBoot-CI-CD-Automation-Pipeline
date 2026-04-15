FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml ./
COPY .mvn .mvn
COPY mvnw mvnw
COPY mvnw.cmd mvnw.cmd
COPY src src
RUN chmod +x mvnw && ./mvnw -q clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/tp-foyer-1.0.jar app.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "app.jar"]
