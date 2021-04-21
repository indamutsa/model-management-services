-- create the databases
CREATE DATABASE IF NOT EXISTS model_storage;

-- create the users for each database
CREATE USER 'arsene'@'localhost' IDENTIFIED BY 'arsene';
GRANT CREATE, ALTER, INDEX, LOCK TABLES, REFERENCES, UPDATE, DELETE, DROP, SELECT, INSERT ON `model_storage`.* TO 'arsene'@'localhost';

FLUSH PRIVILEGES;