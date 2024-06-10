Microservices Project with Spring Boot and Vue.js for the P9 of the path DA Java from Openclassrooms

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/Jilvo/medilabo_solutions/blob/master/LICENSE)
[![Spring](https://img.shields.io/badge/spring-3.2.4-6DB33F)](https://docs.spring.io/spring-framework/reference/index.html)
[![Java](https://img.shields.io/badge/Java-17-red)](https://docs.oracle.com/en/java/)
[![Vue.js](https://img.shields.io/badge/Vue.js-3.4.21-51bc7b)](https://vuejs.org/guide/introduction)
[![Coverage](https://img.shields.io/badge/Coverage-0%-red)](https://github.com/Jilvo/medilabo_solutions/blob/master/LICENSE)

## Table of Contents

- [Table of Contents](#table-of-contents)
- [Introduction](#introduction)
- [Architecture](#architecture)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Services](#running-the-services)
  - [Stopping the Services](#stopping-the-services)
  - [Starting the Services](#starting-the-services)
  - [Health Checks](#health-checks)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
  - [Patient Service](#patient-service)
  - [Note Service](#note-service)
  - [Report Service](#report-service)
  - [Health Check Endpoints](#health-check-endpoints)
- [Green Code](#green-code)
- [Contributing](#contributing)
- [License](#license)
- [TODO](#todo)

## Introduction

This project is a microservices-based application built with Spring Boot for the backend and Vue.js for the frontend. The goal is to demonstrate the structure and functionality of a microservices architecture with a Gateway, separate backend services, and a Single Page Application (SPA) frontend.

## Architecture

The project architecture consists of the following components:

- **Gateway**: Spring Cloud Gateway for routing and managing requests.
- **Backend Services**:
  - **Patient Service**: Manages patients and interacts with MySQL database.
  - **Note Service**: Manages notes and interacts with MongoDB database.
  - **Report Service**: Manages reports.
- **Frontend**: Vue.js application for the user interface.
- **Data Service**: 
  - **MySQL**: Used by the Patient Service to store and manage patient data.
  - **MongoDB**: Used by the Note Service to store and manage notes.
  
## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Node.js 10 or higher
- Docker (optional, for running services in containers)

## Installation
```sh
git clone htthttps://github.com/Jilvo/medilabo_solutions.git
cd your-repo
```
## Configuration
## Running the Services
To manage the microservices, a justfile is provided. It includes commands to build and run the services using Docker. For more information on just, refer to the [Just documentation](https://github.com/casey/just).

First, package the microservices and build the Docker images:
```sh
just package-docker-all
```
### Stopping the Services
Then, start the services using Docker Compose:
```sh
just docker-up
```
### Starting the Services
To stop the services, run:
```sh
just docker-down
```
### Health Checks
You can check the health of each microservice using the following commands:
```sh
just check_health_patient
just check_health_notes
just check_health_report
just check_health_gateway
just check_health_front
```
Or check the health of all services at once:
```sh
just check_health
```
## Usage
## API Endpoints
### Patient Service
    GET /patients/{{id}}: Retrieve patient by ID
    POST /patients: Create a new patient
    PUT /patients/{{id}}: Update patient by ID
    DELETE /patients/{{id}}: Delete patient by ID
### Note Service
    GET /notes: Retrieve all notes
    POST /notes: Create a new note
    PUT /notes/{{id}}: Update note by ID
    DELETE /notes/{{id}}: Delete note by ID
    GET /notes/patId/{{patId}}: Retrieve all notes by patient ID
### Report Service
    GET /report/{{id}}: Get report of a patient by ID
### Health Check Endpoints
    GET /actuator/health: Check health of Microservice Patient (port 9000) and Microservice Note (port 9001) and Microservice Report (port 9002)
## Green Code
  - Eviter la duplication de code
  - Utiliser des images Docker légères
  - Réduire les requêtes de base de données
  - Eviter la duplication des données
## Contributing
If you wish to contribute to this project, please fork the repository and create a pull request with your changes. Make sure to follow the coding standards and include relevant tests.

## License
This project is licensed under the MIT License. See the [LICENSE](https://github.com/Jilvo/medilabo_solutions/blob/master/LICENSE) file for more details.

## TODO 
-  Tests
-  Fix Gateway with URL
-  Ajouter mentions GreenCode dans le Readme.md (Image Slim Docker)
- Le readme.md possède une ou plusieurs suggestions pour la mise en oeuvre du Green Code dans le projet, par exemple : 
  minimiser les fonctionnalités peu utilisées, 
  optimiser les données stockées dans la BDD ;
- Vérifier les rapports
-  L’étudiant est capable de justifier sa mise en place des microservices
-  L’étudiant est capable d’expliquer les principes et les enjeux du Green Code ; 
-  L’étudiant est capable de justifier la normalisation.
-  L’étudiant est capable d’expliquer l’utilisation de la base de données NoSQL.
  
  Présentation des livrables (15 minutes)
Démonstration fonctionnelle de l’application finale et mise en avant des points clés du code.
Explication sur la façon dont vous pourrez appliquer le Green Code.
Discussion (10 minutes)
L’évaluateur jouera le rôle de votre Responsable Produit. Il vous challengera sur votre méthodologie et vos livrables : 
Le découpage en microservices est-elle la meilleure architecture pour ce projet?
En quoi la base NoSQL est parfaitement adaptée pour ce besoin?
Comment peut-on limiter le recours à du code énergivore (complexité algorithmique, appel inutile...)?
Identifier des pistes pour du refactoring green.
Débrief (5 minutes)
À la fin de la soutenance, l'évaluateur arrêtera de jouer le rôle de Taylor pour vous permettre de débriefer ensemble.

- 9000 : Patient
- 9001 : Notes
- 9002 : Report
- 5173 /8080: Front Dev
- 8000 : Gateway

USE microservicepatient;
SHOW TABLES;

Suppresion Poids triggersWords