# BuyBuddy Microservices

## Overview

BuyBuddy is a Spring Boot microservices-based e-commerce application designed to demonstrate the migration of a monolithic system into smaller, independently deployable services. The platform manages Customers, Products, and Orders using Spring Cloud components for service discovery, API routing, and inter-service communication.

---

# Architecture

The application follows a Microservices Architecture with dedicated services for different business domains:

- buy-buddy-customer-service – Handles customer-related operations
- buy-buddy-product-service – Manages product catalog and inventory
- buy-buddy-order-service – Handles order creation and order management

Infrastructure and communication components:

- Eureka Server – Service registry and discovery
- Spring Cloud Gateway – Central API routing layer
- OpenFeign – Inter-service REST communication

---

# Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 21, Spring Boot 3.4.x, Spring Cloud |
| Database | MySQL |
| Microservices | Eureka Server, OpenFeign, Spring Cloud Gateway |
| Cloud & DevOps | Docker, GitHub Actions, CI/CD Pipelines |
| Build Tool | Gradle |
| API Testing | Postman |

---

# Architecture Overview

```text
Client
   ↓
Spring Cloud Gateway
   ↓
---------------------------------------------------
| Customer Service | Product Service | Order Service |
---------------------------------------------------
   ↓
MySQL Database
````

---

# Key Features

* Microservices-based e-commerce backend architecture
* Service discovery using Eureka Server
* API Gateway routing using Spring Cloud Gateway
* Inter-service communication using OpenFeign
* Dockerized deployment workflows for backend services
* CI/CD-based build workflows for automated application build processes
* Scalable backend service orchestration and modular application design

---

# Database Setup

Create the MySQL database:

```sql
CREATE DATABASE buybuddy_microservices_mysql_db;
```

Update database credentials inside each service:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/buybuddy_microservices_mysql_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

# Running the Application

## Start Eureka Server

```bash
./gradlew bootRun
```

Access Eureka Dashboard:

```text
http://localhost:8761
```

---

# Start Services

Run the following services individually:

* buy-buddy-customer-service
* buy-buddy-product-service
* buy-buddy-order-service

Verify all services are successfully registered with Eureka Server.

---

# Docker Setup

Run containerized services using Docker Compose:

```bash
docker-compose up -d
```

---

# Testing

Use Postman to test:

* Customer APIs
* Product APIs
* Order APIs

Verify:

* CRUD operations
* Inter-service communication
* Gateway routing
* Service discovery workflows

---

# Key Learnings

* Understanding of microservices architecture and distributed systems
* Implementation of Service Discovery, API Gateway, and inter-service communication
* Dockerized deployment workflows and CI/CD-based build processes
* Migration of monolithic architecture into scalable Spring Boot microservices

---

# Author
Rahul Prabhakar

```
```
