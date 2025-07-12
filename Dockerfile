# --- Etapa 1: Construcción (Build Stage) ---
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# --- Etapa 2: Ejecución (Runtime Stage) ---
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
RUN apt-get update && apt-get install -y ca-certificates && apt-get clean
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]