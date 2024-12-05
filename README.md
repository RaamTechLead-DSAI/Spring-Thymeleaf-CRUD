# Spring Thymeleaf CRUD Application

This repository contains a basic CRUD (Create, Read, Update, Delete) application built using **Spring Boot** and **Thymeleaf**. The project demonstrates a simple web application that manages entities with a complete front-end interface for data manipulation.

## Features
- **Spring Boot**: Simplifies application setup and development.
- **Thymeleaf**: Server-side templating for rendering dynamic HTML views.
- **CRUD Operations**: Perform Create, Read, Update, and Delete operations on entities.
- **MVC Architecture**: Demonstrates the use of Model-View-Controller design.
- **MySQL Database Integration**: Connects to a MySQL database for data persistence.

## Prerequisites
- **Java 17** or higher
- **Maven 3.6+**
- **MySQL Database**
- **IntelliJ IDEA** (recommended IDE)

## Project Setup

### 1. Clone the Repository
```bash
git clone https://github.com/RaamTechLead-DSAI/Spring-Thymeleaf-CRUD.git
cd Spring-Thymeleaf-CRUD
```
### 2. Configure MySQL Database
- spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
- spring.datasource.username=your_username
- spring.datasource.password=your_password
- spring.jpa.hibernate.ddl-auto=update

### 3. Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```
### 4. Access the Application
http://localhost:8080/

#CRUD Operations Overview
Create: Add a new entity using the form on the homepage.
Read: View the list of all entities.
Update: Edit an existing entity using the edit option.
Delete: Remove an entity from the list.

src
├── main
│   ├── java
│   │   └── com.example.demo    # Java source files
│   ├── resources
│   │   ├── static              # CSS, JS, images
│   │   ├── templates           # Thymeleaf HTML templates
│   │   └── application.properties
└── test                        # Unit and integration tests

# License
This project is licensed under the MIT License. See the LICENSE file for details
