-- create the databases
CREATE DATABASE IF NOT EXISTS dbauth;

-- create the users for each database
CREATE USER 'arsene'@'localhost' IDENTIFIED BY 'arsene';
GRANT CREATE, ALTER, INDEX, LOCK TABLES, REFERENCES, UPDATE, DELETE, DROP, SELECT, INSERT ON `dbauth`.* TO 'arsene'@'localhost';

FLUSH PRIVILEGES;