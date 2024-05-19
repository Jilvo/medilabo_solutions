FROM openjdk:17
# FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app

# Copier le fichier JAR de votre application dans l'image Docker
COPY target/microservice-patient-0.0.1-SNAPSHOT.jar microservice-patient-0.0.1-SNAPSHOT.jar
# Copy the script into the Docker image
# COPY wait-for-it.sh /wait-for-it.sh

# Make the script executable
# RUN chmod +x /wait-for-it.sh
# Commande pour exécuter votre application Spring Boot au démarrage du conteneur
# CMD ["/wait-for-it.sh", "mysql:3306", "--","java", "-jar", "microservice-patient-0.0.1-SNAPSHOT.jar"]
CMD ["java", "-jar", "microservice-patient-0.0.1-SNAPSHOT.jar"]