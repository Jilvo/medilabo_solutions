Microservices Project with Spring Boot and Vue.js for the P9 of the path DA Java from Openclassrooms

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/Jilvo/medilabo_solutions/blob/master/LICENSE)
[![License: MIT](https://img.shields.io/badge/spring-3.2.4-6DB33F)](https://docs.spring.io/spring-framework/reference/index.html)
[![License: MIT](https://img.shields.io/badge/Java-17-red)](https://docs.oracle.com/en/java/)
[![License: MIT](https://img.shields.io/badge/Vue.js-3.4.21-51bc7b)](https://vuejs.org/guide/introduction)
[![License: MIT](https://img.shields.io/badge/Coverage-0%-red)](https://github.com/Jilvo/medilabo_solutions/blob/master/LICENSE)

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
    GET /api/patients/{{id}}: Retrieve patient by ID
    POST /api/patients: Create a new patient
    PUT /api/patients/{{id}}: Update patient by ID
    DELETE /api/patients/{{id}}: Delete patient by ID
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

## Contributing
If you wish to contribute to this project, please fork the repository and create a pull request with your changes. Make sure to follow the coding standards and include relevant tests.

## License
This project is licensed under the MIT License. See the [LICENSE](https://github.com/Jilvo/medilabo_solutions/blob/master/LICENSE) file for more details.

## TODO 
-  Tests
-  Minifying Front
-  Fix Gateway with URL
-  JavaDoc
-  Readme

- 9000 : Patient
- 9001 : Notes
- 9002 : Report
- 5173 /8080: Front Dev
- 8000 : Gateway

USE microservicepatient;
SHOW TABLES;

Suppresion Poids triggersWords