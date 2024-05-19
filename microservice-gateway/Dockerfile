FROM openjdk:17

WORKDIR /app

# Copier le fichier JAR de votre application dans l'image Docker
COPY target/microservice-gateway-0.0.1-SNAPSHOT.jar microservice-gateway-0.0.1-SNAPSHOT.jar

# Commande pour exécuter votre application Spring Boot au démarrage du conteneur
CMD ["java", "-jar", "microservice-gateway-0.0.1-SNAPSHOT.jar"]