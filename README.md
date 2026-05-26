# BuyBuddy Microservices

## Overview

BuyBuddy is a microservices-based e-commerce backend application built using Java, Spring Boot, and Spring Cloud. The project demonstrates how a monolithic application can be broken into independently deployable and scalable microservices using modern backend and cloud-native development practices.

The platform manages Customers, Products, and Orders through dedicated services while implementing service discovery, API gateway routing, inter-service communication, containerization, and CI/CD workflows.

This project was also used to explore Docker, AWS deployments, Kubernetes basics, GitHub Actions CI/CD pipelines, and production-style debugging workflows.

---

# Architecture

The application follows a distributed Microservices Architecture where each business domain is managed independently.

## Core Services

### buy-buddy-customer-service

Handles:

* Customer creation
* Customer retrieval
* Customer management workflows
* REST API operations for customer domain

### buy-buddy-product-service

Handles:

* Product catalog management
* Product CRUD operations
* Inventory-related workflows
* Product service APIs

### buy-buddy-order-service

Handles:

* Order creation
* Order management
* Inter-service communication with Product and Customer services
* Order processing workflows

---

# Infrastructure Components

### Eureka Server

Used for:

* Service registration
* Service discovery
* Dynamic microservice communication

### Spring Cloud Gateway

Acts as:

* Central API Gateway
* Request routing layer
* Single entry point for client requests

### OpenFeign

Used for:

* Inter-service REST communication
* Simplified HTTP client integration between services

---

# Tech Stack

| Layer            | Technology                            |
| ---------------- | ------------------------------------- |
| Backend          | Java 21, Spring Boot 3.x              |
| Microservices    | Spring Cloud, Eureka, OpenFeign       |
| API Gateway      | Spring Cloud Gateway                  |
| Database         | MySQL                                 |
| Build Tool       | Gradle                                |
| Containerization | Docker                                |
| CI/CD            | GitHub Actions                        |
| Cloud & DevOps   | AWS EC2, DockerHub, Kubernetes Basics |
| API Testing      | Postman                               |

---

# Architecture Flow

```text
Client
   ↓
Spring Cloud Gateway
   ↓
---------------------------------------------------------
| Customer Service | Product Service | Order Service |
---------------------------------------------------------
   ↓
MySQL Database
```

---

# Features Implemented

## Microservices-Based Backend Architecture

* Designed independently deployable backend services
* Implemented modular service separation for scalability
* Explored distributed system communication workflows

## Service Discovery with Eureka Server

* Registered all backend services dynamically
* Enabled service-to-service communication using Eureka Discovery

## API Gateway Integration

* Configured centralized request routing
* Managed API access through Spring Cloud Gateway
* Simplified client interaction with microservices

## Inter-Service Communication

* Implemented REST-based communication using OpenFeign
* Connected Order Service with Customer and Product services

## Dockerized Deployment Workflows

* Containerized all backend microservices using Docker
* Created multi-stage Dockerfiles for optimized image builds
* Worked on Docker networking and container communication

## CI/CD Pipeline Integration

* Configured GitHub Actions workflows for automated builds
* Implemented microservices-based CI validation pipelines
* Automated Gradle build workflows for all services

## Kubernetes & Container Orchestration Exploration

* Explored Kubernetes deployment concepts using Minikube
* Worked with Kubernetes Deployments, Services, Pods, and NodePort exposure
* Practiced container orchestration and deployment troubleshooting

## Cloud Deployment Workflows

* Explored AWS EC2-based deployment workflows
* Pulled Docker images from DockerHub into EC2 environments
* Worked on container deployment and runtime debugging

## Production Debugging & Monitoring

* Debugged Docker container startup issues
* Worked on service exposure and networking troubleshooting
* Used logs and deployment validation commands for debugging workflows

---

# Database Setup

Create MySQL database:

```sql
CREATE DATABASE buybuddy_microservices_mysql_db;
```

Update database configuration inside services:

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

# Start Microservices

Run services individually:

* buy-buddy-customer-service
* buy-buddy-product-service
* buy-buddy-order-service

Verify services are registered successfully in Eureka Server.

---

# Docker Setup

## Build Docker Images

```bash
docker build -t customer-service .
```

## Run Containers

```bash
docker run -d -p 8081:8081 customer-service
```

## Docker Compose

```bash
docker-compose up -d
```

---

# GitHub Actions CI/CD

Implemented GitHub Actions workflow for:

* Automated microservice builds
* Gradle build validation
* CI pipeline execution on code push
* Multi-service build workflows using matrix strategy

Workflow includes:

* Repository checkout
* JDK setup
* Gradle dependency caching
* Service build automation
* CI failure debugging and validation

---

# Kubernetes Exploration

Practiced Kubernetes concepts using:

* Minikube
* Deployments
* Services
* Pods
* NodePort exposure

Common kubectl commands explored:

```bash
kubectl get pods
kubectl logs <pod-name>
kubectl describe pod <pod-name>
kubectl exec -it <pod-name> -- /bin/bash
```

---

# Testing

Used Postman for validating:

* Customer APIs
* Product APIs
* Order APIs
* Gateway routing
* Inter-service communication
* Service discovery workflows

---

# Key Learnings

* Microservices architecture and distributed systems
* Service discovery and API Gateway implementation
* Docker containerization and networking
* CI/CD workflows using GitHub Actions
* Kubernetes deployment basics and orchestration concepts
* AWS deployment workflows and cloud-hosted application management
* Deployment troubleshooting and production debugging practices

---

# Future Improvements

* Kubernetes deployment automation
* Helm chart integration
* Monitoring with Prometheus & Grafana
* Centralized logging
* API security enhancements
* Autoscaling and production-grade orchestration

---

# Author

Rahul Prabhakar
