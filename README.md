# Gest Edu

## Introduction
Gest Edu is a web application designed to manage educational institutions, including schools and colleges. It provides features for managing students, teachers, courses, and more.

## Technologies Used
- **Backend**: Java with Spring Boot
- **Database**: PostgreSQL
- **Docker**: For containerization
- **Docmentation**: Swagger for API documentation

## Create file .env in root with the following content
```bash
DB_URL=jdbc:postgresql://db:5432/db_gest_edu
DB_USERNAME=postgres
DB_PASSWORD=POSTGRES_PASSWORD
POSTGRES_DB=db_gest_edu
POSTGRES_USER=postgres
POSTGRES_PASSWORD=POSTGRES_PASSWORD
```

## Prerequisites
- Docker installed on your machine
- Java Development Kit (JDK) 21 or higher
- Execute the following command to check if Docker is running:
```bash
docker --version
```
- Execute the following command to check if Java is installed:
```bash
java -version
```
## Running the Application
1. **Clone the Repository**:
```bash
   git clone https://github.com/gabrielcaio11/GestEdu.git
 ```  
2. **Navigate to the Project Directory**:
```bash
   cd gest-edu
```
3. **Execute the Docker Compose Command**:
```bash
   docker-compose up --build
```

## Accessing the Application after Running
- Swagger UI will be available at <a href="http://localhost:8080/swagger-ui/index.html" target="_blank">http://localhost:8080/swagger-ui/index.html</a>

