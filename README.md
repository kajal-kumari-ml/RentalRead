# RentalRead
Develop a RESTful API service using Spring Boot to manage an online book rental system while using MySQL to persist the data.

### Spring Security 
This project demonstrates a simple authentication and authorization system using Spring Security in a Spring Boot application.

### Running the Project
To run the project, you can use the Gradle Wrapper provided in the repository. Follow these steps:


### Open a terminal.


Navigate to the root directory of the project where the build.gradle file is located.


### Run the following command:
./gradlew bootrun



### AuthController
The AuthController class defines endpoints for user authentication and registration.


/register: Endpoint for user registration.

/login: Endpoint for user login.


### Request Objects

### AuthRequest


email: User's email address.

password: User's password.


### RegisterRequest


name: User's name.

email: User's email address.

password: User's password.

role: User's role. Default role is USER if not specified.


### Response Objects

### AuthResponse


message: Success message.

### Postman

🔗 https://winter-flare-851632.postman.co/workspace/kajal~ed0bd169-879d-4182-a30e-8d7e212ef617/collection/15511430-a03d7840-52d8-49a4-832f-0a2eea6e5232?action=share&creator=15511430
