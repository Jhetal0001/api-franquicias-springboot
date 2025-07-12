# Usa una imagen base de Java. OpenJDK 17 es una excelente opción para Spring Boot 3.
FROM openjdk:17-jdk-slim

# Argumento para especificar la ruta del archivo JAR que genera Maven o Gradle.
ARG JAR_FILE=target/*.jar

# Copia el archivo JAR generado a la imagen del contenedor con un nombre simple.
COPY ${JAR_FILE} app.jar

# Expone el puerto en el que correrá la aplicación dentro del contenedor.
EXPOSE 8080

# El comando que se ejecutará cuando el contenedor inicie.
ENTRYPOINT ["java", "-jar", "/app.jar"]