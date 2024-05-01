recipe-name: echo 'This is a recipe!'

# compose-build: docker-compose up --build
# docker-build-medilabo-patient: cd microservice-patient && docker build -t medilabo-patient .

# docker-build-medilabo-notes: cd microservice-notes && docker build -t medilabo-notes .

# docker-build-medilabo-report: cd microservice-rapport && docker build -t medilabo-rapport .

# docker-build-medilabo-front: cd medilabo-front && docker build -t medilabo-front .

package-patient: cd microservice-patient && mvn clean package
package-notes: cd microservice-notes && mvn clean package
package-report: cd microservice-report && mvn clean package

docker-all: just docker-build-medilabo-patient
  just docker-build-medilabo-notes
  just docker-build-medilabo-report
  just docker-build-medilabo-front
