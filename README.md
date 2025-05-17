# Notification Service

A microservice to send notifications to users via **Email**, **SMS**, and **In-App**, built with **Spring Boot**, **RabbitMQ**, and **JPA**.

---

## Features

- REST API to send and fetch user notifications
- Supports Email, SMS, and In-App notifications
-  Uses RabbitMQ for asynchronous queue-based processing
- Retry mechanism for failed notifications
- Stores notifications using JPA (PostgreSQL)

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- RabbitMQ
- PostgreSQL
- Docker (for RabbitMQ)

---

##  API Endpoints

## Send Notification

http
POST /notifications


## Project Structure:

notification-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/notification/
│   │   │       ├── controller/
│   │   │       │   └── NotificationController.java
│   │   │       ├── model/
│   │   │       │   └── Notification.java
│   │   │       ├── repository/
│   │   │       │   └── NotificationRepository.java
│   │   │       ├── service/
│   │   │       │   ├── NotificationService.java
│   │   │       │   └── NotificationSender.java
│   │   │       ├── config/
│   │   │       │   └── RabbitMQConfig.java
│   │   │       └── NotificationServiceApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   │       └── templates/
│
├── docker-compose.yml
├── pom.xml
├── README.md
└── .gitignore

