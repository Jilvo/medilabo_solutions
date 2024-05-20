# Start the microservices
docker-up: 
  docker-compose up --build

# Stop the microservices
docker-down: 
  docker-compose down --remove-orphans

# Package the patient microservice
package-patient:
  cd microservice-patient && mvn clean package && docker build -t medilabo-patient . && cd ..

# Package the notes microservice
package-notes:
  cd microservice-notes && mvn clean package && docker build -t medilabo-notes . && cd ..

# Package the report microservice
package-report:
  cd microservice-rapport && mvn clean package && docker build -t medilabo-rapport . && cd ..

# Package the gateway microservice
package-gateway:
  cd microservice-gateway && mvn clean package && docker build -t medilabo-gateway . && cd ..

# Package the front microservice
package-front:
  cd medilabo-front && docker build -t medilabo-front . && cd ..

# Package all the microservices
package-all:
  just package-patient
  just package-notes
  just package-report
  just package-gateway
  just package-front
# Build the patient microservice
docker-build-medilabo-patient: 
  cd microservice-patient && docker build -t medilabo-patient .
# Build the notes microservice
docker-build-medilabo-notes: 
  cd microservice-notes && docker build -t medilabo-notes .
# Build the report microservice
docker-build-medilabo-report: 
  cd microservice-rapport && docker build -t medilabo-rapport .
# Build the gateway microservice
docker-build-medilabo-gateway: 
  cd microservice-gateway && docker build -t medilabo-gateway .
# Build the front microservice
docker-build-medilabo-front: 
  cd medilabo-front && docker build -t medilabo-front .
# Build all the microservices
docker-all: 
  just docker-build-medilabo-patient
  just docker-build-medilabo-notes
  just docker-build-medilabo-report
  just docker-build-medilabo-gateway
  just docker-build-medilabo-front
# Package and build all the microservices
package-docker-all: 
  just package-all
  just docker-all

check_health_patient:
  @echo "Checking health... microservice-patient"
  @curl -s -o /dev/null -w "Status code : %{http_code}" http://localhost:9000/actuator/health
  @echo " "
check_health_notes:
  @echo "Checking health... microservice-notes"
  @curl -s -o /dev/null -w "Status code : %{http_code}" http://localhost:9001/actuator/health
  @echo " "
check_health_report:
  @echo "Checking health... microservice-report"
  @curl -s -o /dev/null -w "Status code : %{http_code}" http://localhost:9002/actuator/health
  @echo " "
check_health_gateway:
  @echo "Checking health... microservice-gateway"
  @curl -s -o /dev/null -w "Status code : %{http_code}" http://localhost:8000/actuator/health
  @echo " "
check_health_front:
  @echo "Checking health... microservice-front"
  @curl -s -o /dev/null -w "Status code : %{http_code}" http://localhost:8080
  @echo " "

# Check the health of all the microservices
check_health:
    just check_health_gateway
    just check_health_report
    just check_health_notes
    just check_health_front
    just check_health_patient 