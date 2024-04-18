-- CREATED BY: William Hellems-Moody
-- DATE: 2024-04-18

CREATE DATABASE tasks_management;

\c tasks_management;

-- Drop the existing tables
DROP TABLE tasks;
DROP TABLE categories;
DROP TABLE users;
DROP TABLE status;

-- NORMALIZED THE DATABASE TO 2NF

-- User table
CREATE TABLE Users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Category table
CREATE TABLE Categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE Status (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Task table
CREATE TABLE Tasks (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    descr VARCHAR(255) NOT NULL,
    due_date TIMESTAMP,
    priority VARCHAR(10), -- low, medium, high
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    user_id INT, 
    category_id INT,
    status_id INT, -- 1: pending, 2: in-progress, 3: completed
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (category_id) REFERENCES Categories(id),
    FOREIGN KEY (status_id) REFERENCES Status(id)
);

-- GRANT Permissions FOR ADMIN
GRANT ALL PRIVILEGES ON DATABASE tasks_management TO postgres;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO postgres;

-- Insert users
INSERT INTO Users (username, email, password) VALUES
('admin', 'admin@taskmanager.com', 'secureAdminPass!'),
('john_doe', 'john.doe@example.com', 'password123'),
('jane_smith', 'jane.smith@example.com', 'secureJanePass!'),
('alice_brown', 'alice.brown@example.com', 'aliceSecurePass!');

-- Insert categories
INSERT INTO Categories (name) VALUES
('Work'),
('Personal'),
('Health & Fitness'),
('Finance'),
('Learning'),
('Chores'),
('Miscellaneous');

-- Insert status
INSERT INTO Status (id, name) VALUES
(1, 'pending'),
(2, 'in-progress'),
(3, 'completed');

-- Insert tasks
INSERT INTO Tasks (title, descr, due_date, status_id, priority, user_id, category_id) VALUES
('Complete project report', 'Finish the annual project report and submit it', '2024-06-15', 1, 'high', 2, 1),
('Grocery shopping', 'Buy groceries for the week', '2024-04-18', 2, 'medium', 3, 6),
('Morning workout', 'Attend gym session', '2024-04-19', 3, 'high', 4, 3),
('Budget review', 'Review monthly budget and expenses', '2024-04-20', 1, 'medium', 1, 4),
('Read a book', 'Read the next chapter of the book', '2024-04-21', 1, 'low', 2, 5),
('Laundry', 'Wash, dry, and fold laundry', '2024-04-18', 2, 'low', 3, 6),
('Meditate', 'Meditate for 20 minutes', '2024-04-19', 3, 'medium', 4, 3),
('Meeting with clients', 'Discuss project details with clients', '2024-04-20', 2, 'high', 1, 1),
('Family gathering', 'Attend family gathering at home', '2024-04-21', 1, 'low', 2, 2);


-- SELECT STATEMENTS:
-- List all tasks
SELECT * FROM Tasks;

-- List all categories
SELECT * FROM Categories;

-- List all users
SELECT * FROM Users;

-- List total number of tasks associated with category 'Work'
SELECT COUNT(*) AS total FROM Tasks A
JOIN Categories B
ON A.category_id = B.id
WHERE B.name = 'Work';

-- List all tasks names with status 'pending'
SELECT A.title, C.name AS status FROM Tasks A
JOIN Status C
ON A.status_id = C.id
WHERE C.name = 'pending';