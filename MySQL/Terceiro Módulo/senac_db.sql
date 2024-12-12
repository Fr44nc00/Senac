DROP DATABASE IF EXISTS senac_db;
CREATE DATABASE senac_db;
GRANT ALL PRIVILEGES ON senac_db.* TO 'root'@'localhost';
FLUSH PRIVILEGES;
USE senac_db;