# BuyBuddy Microservices

## Overview
BuyBuddy is a **Spring Boot microservices-based e-commerce application** that demonstrates the migration of a monolithic system into smaller, independent services. It manages **Customers**, **Products**, and **Orders**, leveraging **Spring Cloud** components for service discovery and inter-service communication.

---

##  Architecture
The project follows the **Microservices Architecture**, splitting the application into three services:
1. **buy-buddy-customer-service** – Handles customer-related operations.
2. **buy-buddy-product-service** – Manages product catalog and inventory.
3. **buy-buddy-order-service** – Handles order creation, tracking, and associations.

All services register with:
- **Eureka Server** – Acts as a **Service Registry**.
- **Spring Cloud Gateway** – Routes external API calls to respective services.
- **Feign Client** – Simplifies REST API calls between services.

---

##  Tech Stack
- **Java 21**
- **Spring Boot 3.4.x**
- **Spring Cloud 2024.0.0**
- **Spring Data JPA**
- **Spring Cloud Gateway**
- **Eureka Server & Feign Client**
- **MySQL Database**
- **Gradle Build Tool**

---

##  Database Setup
Create a MySQL database before running the services:
```sql
CREATE DATABASE buybuddy_microservices_mysql_db;


Update credentials in each service’s application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/buybuddy_microservices_mysql_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

# Running the Application

Start Eureka Server:

./gradlew bootRun


Access registry at http://localhost:8761

Run all services:

buy-buddy-customer-service

buy-buddy-product-service

buy-buddy-order-service

Verify all services are registered with Eureka.

 Testing

Use Postman to test API endpoints for Customers, Products, and Orders.
Ensure all CRUD operations and inter-service calls work as expected.

 Key Learnings

Understanding of microservices architecture and communication.

Implementing Service Discovery, API Gateway, and Load Balancing.

Migration of monolith to microservices using Spring Boot and Spring Cloud.


Update credentials in each service’s application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/buybuddy_microservices_mysql_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

 Running the Application

Start Eureka Server:

./gradlew bootRun


Access registry at http://localhost:8761

Run all services:

buy-buddy-customer-service

buy-buddy-product-service

buy-buddy-order-service

Verify all services are registered with Eureka.

 Testing

Use Postman to test API endpoints for Customers, Products, and Orders.
Ensure all CRUD operations and inter-service calls work as expected.

Key Learnings

Understanding of microservices architecture and communication.

Implementing Service Discovery, API Gateway, and Load Balancing.

Migration of monolith to microservices using Spring Boot and Spring Cloud.

 Author

Rahul Prabhakar

