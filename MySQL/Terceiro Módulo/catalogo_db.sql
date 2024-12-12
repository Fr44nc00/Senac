DROP DATABASE IF EXISTS catalogo_db;
CREATE DATABASE catalogo_db;
GRANT ALL PRIVILEGES ON catalogo_db.* TO 'root'@'localhost';
FLUSH PRIVILEGES;

USE catalogo_db;
SELECT * FROM catalogo_db;