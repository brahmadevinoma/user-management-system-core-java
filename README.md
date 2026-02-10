# User Management System (Core Java)

## Description
A Core Java–based backend-style User Management and Authentication System that allows users to register and login using either user ID or username.

## Features
- User registration with unique user ID and username
- Login using user ID or username
- Password update functionality
- User deletion
- Custom exception handling
- Clean package structure following backend best practices

## Technologies Used
- Core Java
- Java Collections (HashMap)
- Object-Oriented Programming (OOP)
- Exception Handling

## Project Structure
src/
└── com.usermanagement
├── app
│ └── MainApp.java
├── model
│ └── User.java
├── service
│ └── UserService.java
└── exception
├── UserAlreadyExistsException.java
├── UserNotFoundException.java
└── InvalidCredentialsException.java

## How to Run
1. Clone the repository
2. Compile all Java files
3. Run `MainApp.java`

## Future Enhancements
- Add Java 8 features (Streams, Lambdas)
- File or database persistence
- Convert to Spring Boot REST API
