# Coffeeshop Order Service

This is microsservice part of a sample project named Coffeeshop, showcasing the implementation of various microservices components using Spring Boot
with object to simulate a coffee shop responsible to food and beverage calories consumed by employees.

## Table of Contents

- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [Endpoints](#endpoints)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Coffeeshop is a microservices project that aims to demonstrate the implementation of microservices architecture using 
Spring Boot. The project consists of multiple microservices including initially order service, product service and user service.

## Technologies Used

- Java 17
- Spring Boot 3.1.2
- Spring Security with OAuth2
- Spring Data JPA
- Springdoc for API Documentation
- PostgreSQL Database
- Docker
- Kafka (for message queuing)

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/Tuliohos/coffeeshop.order-service.git

2. Customize your configuration:

Configure database connections and other application properties in application.yml files.
Set up OAuth2 client credentials and properties in the respective configuration files.

3. Build the project:
    ```bash
    ./mvnw clean package
4. Run the microservice and its associated database
    ```bash
    docker-compose up -d

## Future features
As part of the constant development. Here ir some of the features that are mapped to be implemented:

- Implementation of unit tests on order-service and integrated tests using TestContainers in all microservices
- Implementation of user-service.
- Async communication (using kafka) between product-service and order-service always when a product is created/updated/deleted.
- Implementation of OAuth2 authentication in all microservices (including dedicated key for each user).
- Hosting the microservices in a cloud platform with pipelines.
- Applying more business rule to calculate the calorie amount consumed by each user.
- Soft delete on orders and users databases.
- Monitoring tools like Prometheus and Grafana.