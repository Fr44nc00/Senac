/*
drop database if exists exemplo_senac_2;
*/
create database exemplo_senac_2;

use exemplo_senac_2;
create table funcionarios(
    matricula varchar(70) NOT NULL,
    nome varchar(70) NOT NULL,
    cargo varchar(70) NOT NULL,
    salario double NOT NULL,
    PRIMARY KEY (matricula)
);