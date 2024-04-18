# Task Management API

### Created by: [William Hellems-Moody](https://www.williamhmoody.com)

GOAL OF PROJECT: To test my abilities to construct a simple task management API using my existing knowledge in DB Design and working with DBMS, and Spring Boot framework.
This is a Simple API that provides functionality for managing tasks, users, categories, and statuses in a task management system. This is a standalone API, which aims to solve the problem of managing tasks and users in a simple and efficient way.

## API Endpoints

***Test API Endpoints using Postman or any other API testing tool.***

## Users

### `GET /api/users`
### `GET /api/users/{id}`
### `GET /api/users/{id}/tasks`

### `POST /api/users`
### `PUT /api/users/{id}`
### `DELETE /api/users/{id}`

## Tasks

### `GET /api/tasks`
### `GET /api/tasks/{id}`
### `GET /api/tasks/user/{userId}`
### `GET /api/tasks/category/{categoryId}`
### `GET /api/tasks/status/{statusId}`
### `GET /api/tasks/due/{dueDate}`

### `POST /api/tasks`
### `PUT /api/tasks/{id}`
### `DELETE /api/tasks/{id}`

## Categories

### `GET /api/categories`
### `GET /api/categories/{id}`
### `POST /api/categories`
### `DELETE /api/categories/{id}`

## Statuses

### `GET /api/statuses`
### `GET /api/statuses/{id}`
### `POST /api/statuses`
### `DELETE /api/statuses/{id}`

## Example Requests and Responses [GET /api/users]
- **Response**: A JSON array of user objects, each containing the following properties:

```json
[
    {
        "id": 1,
        "username": "jane_doe",
        "email": "john.doe@example.com",
        "password": "password123",
        "createdAt": "2024-04-18T16:38:30.915+00:00",
        "updatedAt": "2024-04-18T16:38:30.915+00:00"
    }
]
```

## Example Requests and Responses [POST /api/tasks]
- **Request Body**: A JSON object containing the following properties:

```json
{
    "title": "Complete project report",
    "descr": "Finish the annual project report and submit it",
    "dueDate": "2024-06-15T00:00:00",
    "priority": "high",
    "userId": 2,
    "categoryId": 1,
    "statusId": 1
}
```

- **Response**: A JSON object representing the newly created task, including related entities (`user`, `category`, and `status`).

Example response:

```json
{
    "id": 1,
    "title": "Complete project report",
    "descr": "Finish the annual project report and submit it",
    "dueDate": "2024-06-15T00:00:00",
    "priority": "high",
    "createdAt": "2024-04-18T10:38:30.934811",
    "updatedAt": "2024-04-18T10:38:30.934811",
    "userId": 2,
    "categoryId": 1,
    "statusId": 1,
    "user": {
        "id": 2,
        "username": "john_doe",
        "email": "john.doe@example.com",
        "password": "password123",
        "createdAt": "2024-04-18T16:38:30.915+00:00",
        "updatedAt": "2024-04-18T16:38:30.915+00:00"
    },
    "category": {
        "id": 1,
        "name": "Work"
    },
    "status": {
        "id": 1,
        "name": "pending"
    }
}
```

## Entities

### Task

- `id`: The unique identifier of the task.
- `title`: The title of the task.
- `descr`: The description of the task.
- `dueDate`: The due date and time of the task in ISO 8601 format (`YYYY-MM-DDTHH:MM:SS`).
- `priority`: The priority level of the task (`low`, `medium`, `high`).
- `createdAt`: The date and time the task was created.
- `updatedAt`: The date and time the task was last updated.
- `userId`: The ID of the user who owns the task.
- `categoryId`: The ID of the category the task belongs to.
- `statusId`: The ID of the status of the task.
- `user`: The user who owns the task, represented as a JSON object.
- `category`: The category of the task, represented as a JSON object.
- `status`: The status of the task, represented as a JSON object.

### User

- `id`: The unique identifier of the user.
- `username`: The username of the user.
- `email`: The email of the user.
- `password`: The hashed password of the user.
- `createdAt`: The date and time the user was created.
- `updatedAt`: The date and time the user was last updated.

### Category

- `id`: The unique identifier of the category.
- `name`: The name of the category.

### Status

- `id`: The unique identifier of the status.
- `name`: The name of the status.

## Getting Started

To run the API locally, follow these steps:

1. **Prerequisites**:
    - **Java**: Ensure you have Java 11 or a later version installed on your system.
    - **PostgreSQL**: Install PostgreSQL on your system. Make sure you have the database credentials (username and password) ready.

2. **Clone the repository**:
    - Clone the repository from GitHub or another version control platform.

3. **Set up the database**:
    - Create a new PostgreSQL database for the application.
    - Update the database connection details in `application.properties` or `application.yml` in the `src/main/resources` directory.
        - Set `spring.datasource.url` to your database URL (e.g., `jdbc:postgresql://localhost:5432/your-database-name`).
        - Set `spring.datasource.username` and `spring.datasource.password` to your PostgreSQL credentials.

4. **Dependencies**:
    - Ensure the application dependencies are configured in your build file (`pom.xml` for Maven or `build.gradle` for Gradle):
        - `org.springframework.boot:spring-boot-starter-data-jpa`: For Spring Data JPA support.
        - `org.springframework.boot:spring-boot-starter-web`: For building web applications.
        - `org.springframework.boot:spring-boot-starter-validation`: For validation support.
        - `org.postgresql:postgresql`: PostgreSQL JDBC driver.
        - `org.projectlombok:lombok`: For Lombok annotations (e.g., `@Data`).
        - `com.fasterxml.jackson.databind`: Jackson library for JSON processing.

5. **Run the application**:
    - Navigate to the project directory in the terminal.
    - Run the application using your build tool:
        - For Maven: `mvn spring-boot:run`
        - For Gradle: `./gradlew bootRun`
    - The application will start on port `8080`.

6. **Test the API**:
    - You can use Postman or another API testing tool to interact with the API.
    - Send requests to the appropriate endpoints to create, retrieve, update, and delete tasks.

## Conclusion

You have set up your task management API to run locally using Spring Boot and PostgreSQL. You can now test the endpoints and begin building additional features and functionality as needed.