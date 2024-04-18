# Task Management Database

***CREATED BY: William Hellems-Moody***

## Overview

This project is designed to create a normalized database setup for a task management system using PostgreSQL. The database schema includes tables for tasks, users, categories, and statuses, as well as the relationships between them. This setup will allow you to practice working with SQL, database normalization, and establishing relationships between tables.

## User Story

As a user, I want to be able to:

- Create, read, update, and delete tasks in a task management system.
- Assign tasks to categories for organization and status for tracking progress.
- Manage users, categories, and statuses in the system.

## Database Design

### Task Entity

- **Table**: `tasks`
- **Columns**:
  - `id`: Primary key, auto-generated.
  - `title`: Title of the task.
  - `descr`: Description of the task.
  - `due_date`: Due date of the task.
  - `priority`: Priority of the task (e.g., low, medium, high).
  - `user_id`: Foreign key referencing the `users` table.
  - `category_id`: Foreign key referencing the `categories` table.
  - `status_id`: Foreign key referencing the `statuses` table.
  - `created_at`: Timestamp of task creation.
  - `updated_at`: Timestamp of task last update.

### User Entity

- **Table**: `users`
- **Columns**:
  - `id`: Primary key, auto-generated.
  - `username`: Username of the user.
  - `email`: Email address of the user.
  - `password`: Hashed password of the user.
  - `created_at`: Timestamp of user creation.
  - `updated_at`: Timestamp of user last update.

### Category Entity

- **Table**: `categories`
- **Columns**:
  - `id`: Primary key, auto-generated.
  - `name`: Name of the category.

### Status Entity

- **Table**: `statuses`
- **Columns**:
  - `id`: Primary key, auto-generated.
  - `name`: Name of the status (e.g., pending, in-progress, completed).

## Sample Data

You can use the following SQL statements to insert sample data into the database tables:

```sql
-- Insert users
INSERT INTO users (username, email, password, created_at, updated_at) VALUES
('admin', 'admin@email.com', 'admin123', NOW(), NOW()),
('user1', 'user01@email.com', 'user123', NOW(), NOW()),
('user2', 'user02@email.com', 'user123', NOW(), NOW());

-- Insert categories
INSERT INTO categories (name) VALUES
('Work'),
('Personal'),
('Shopping');

-- Insert statuses
INSERT INTO statuses (name) VALUES
('Pending'),
('In-progress'),
('Completed');

-- Insert tasks
INSERT INTO tasks (title, descr, due_date, priority, user_id, category_id, status_id, created_at, updated_at) VALUES
('Task 1', 'Complete the project report', '2024-06-15', 'high', 1, 1, 1, NOW(), NOW()),
('Task 2', 'Grocery shopping', '2024-04-30', 'low', 2, 3, 2, NOW(), NOW()),
('Task 3', 'Plan vacation', '2024-07-01', 'medium', 3, 2, 3, NOW(), NOW());
```

## Getting Started

### Database Setup and Installation

1. **Setup the Database**:

   - To run a PostgreSQL Docker container, use the following command:

     ```shell
     docker run --rm --name postgres --publish 5432:5432 -e POSTGRES_PASSWORD=1234 -v /<YOUR PATH HERE>/t_db:/var/lib/postgresql/data postgres

     -- Example:
     docker run --rm --name postgres --publish 5432:5432 -e POSTGRES_PASSWORD=1234 -v /Users/williamhellems-moody/Desktop/t_db:/var/lib/postgresql/data postgres
     ```

2. **Connect to the Database**:

   - To connect to the PostgreSQL database, use the following command:
     ```shell
     docker exec -it postgres psql -U postgres
     ```

3. **Create and Initialize Tables**:

   - Use the provided SQL scripts to create tables and insert sample data into the database.

4. **Practice Working with Relations**:
   - Practice querying and updating the database, joining tables to retrieve related data, and applying filters to your queries.

## Conclusion

This database setup provides a foundation for practicing SQL and working with relational tables in a task management context. Use this setup as a learning experience or as a base for building a more complex application.
