/*drop database principal;*/
create database principal;
use principal;

create table PESSOA (
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOME varchar(100),
    TELEFONE varchar(30),
    IDADE int,
    PESO double,
    CPF varchar(20)
);