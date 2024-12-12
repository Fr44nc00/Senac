/*DROP DATABASE login_exemplo;*/
CREATE DATABASE login_exemplo;
USE login_exemplo;

CREATE TABLE usuario (
	id int PRIMARY KEY AUTO_INCREMENT,
	nome varchar(30),
	login varchar(100),
	senha text,
	tipo varchar(30)
);

INSERT INTO usuario (nome, login, senha) VALUES 
('Teste 1', '123', '123'), 
('Teste 2', '1234', '81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO usuario (nome, login, senha, tipo) VALUES 
('Lucas', 'lucas@email.com', md5('123'), 'Admin'),
('Laura', 'laura@email.com', md5('123'), 'Dev'),
('Luis', 'luis@email.com', md5('123'), 'Vendas');  