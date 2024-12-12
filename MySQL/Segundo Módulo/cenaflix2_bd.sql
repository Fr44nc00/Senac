/*drop database cenaflix2;*/
create database cenaflix2;
use cenaflix2;

create table podcast (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    produtor varchar(30),
    nomeEpisodio varchar(100),
    numEpisodio int,
    duracao varchar(20),
    repositorio varchar(300)
);

create table usuario (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    login varchar(100),
	senha text,
	tipo varchar(30)
);

INSERT INTO usuario (login, senha, tipo) VALUES 
('Franco_Mateus', md5('123'), 'Admin'),
('Bento_Laura', md5('456'), 'Oper'),
('Monteiro_Nadyne', md5('789'), 'Usuario'); 

SELECT * FROM podcast;