-- 1. Create the Database and Table
CREATE DATABASE fip_db;

USE fip_db;

CREATE TABLE people (
    id INT PRIMARY KEY,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    address VARCHAR(100),
    occupation VARCHAR(50),
    date DATE
);

-- 2. Insert into the Table
INSERT INTO people (id, firstname, lastname, address, occupation, date)
VALUES 
    (1, 'Auwalu', 'Hamza', '32 Sharada G Garu', 'Engineer', '2025-06-28'),
    (2, 'Sani', 'Hamza', '31 Sharada G Garu', 'Product Manager', '2025-06-28');

-- 3. Update a Record
UPDATE people
SET occupation = 'Senior Engineer', address = '45 Nassarawa GRA'
WHERE id = 1;

-- 4. Delete a Record
DELETE FROM people
WHERE id = 2;
