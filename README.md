# Carbon cell assignment

This project showcases the utilization of JWT (JSON Web Tokens) for user authentication, development of API endpoints for fetching data from a public API with customizable filtering options, and documentation of these API endpoints through springdoc-OpenAPI (Swagger UI). Additionally, it ensures that certain API endpoints are accessible only to authenticated users, thereby enhancing security.

## Technologies Used
- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)


## Prerequisites
Before running the application, ensure you have the following installed:
- Java Development Kit (JDK)
- Maven
- Postman 

## Getting Started
To run the application, follow these steps:

## Endpoints
- /auth/create (POST): Registers a new user.
- /auth/login (POST): Authenticate a user and generate JWT token.
- /api/publicapis?category={category}&entryLimit={entryLimit} Fetches data from the public API 

