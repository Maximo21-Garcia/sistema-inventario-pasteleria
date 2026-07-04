# Usa una imagen de Java 17 (que es la que elegiste en Spring Initializr) [3]
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Asegúrate de que el nombre del .jar coincida con el que genera tu Maven
COPY target/inventario-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]