FROM openjdk:17

WORKDIR /app

COPY src/main/resources/trigger_words.txt /app/src/main/resources/trigger_words.txt
# Copier le fichier JAR de votre application dans l'image Docker
COPY target/microservice-rapport-0.0.1-SNAPSHOT.jar microservice-rapport-0.0.1-SNAPSHOT.jar

# Commande pour exécuter votre application Spring Boot au démarrage du conteneur
CMD ["java", "-jar", "microservice-rapport-0.0.1-SNAPSHOT.jar"]