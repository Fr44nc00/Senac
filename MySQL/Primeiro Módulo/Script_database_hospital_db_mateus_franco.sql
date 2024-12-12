DROP DATABASE IF EXISTS hospital_db_mateus_franco;

CREATE DATABASE hospital_db_mateus_franco;

USE hospital_db_mateus_franco;

CREATE TABLE Convênios(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome varchar(45) NOT NULL UNIQUE,
cnpj varchar(45) NOT NULL UNIQUE,
tempo_carencia varchar(45) NOT NULL
);

CREATE TABLE Pacientes(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome varchar(45) NOT NULL,
cpf varchar(45) NOT NULL UNIQUE,
data_nasc date NOT NULL,
endereco_completo varchar(45) NOT NULL,
telefone varchar(45) NOT NULL UNIQUE,
email varchar(45) NOT NULL UNIQUE,
rg varchar(45) NOT NULL UNIQUE
);

CREATE TABLE Convênios_Pacientes(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
Pacientes_id int NOT NULL,
Convenios_id int NOT NULL,
FOREIGN KEY (Pacientes_id) REFERENCES Pacientes (id),
FOREIGN KEY (Convenios_id) REFERENCES Convênios (id)
);

CREATE TABLE Médicos(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome varchar(45) NOT NULL,
cpf varchar(45) NOT NULL UNIQUE,
data_nasc date NOT NULL,
crm varchar(45) NOT NULL UNIQUE,
uf_crm varchar(45) NOT NULL,
telefone varchar(45) NOT NULL UNIQUE,
endereco_completo varchar(45) NOT NULL
);

CREATE TABLE Consultas(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_paciente int NOT NULL,
id_medico int NOT NULL,
id_convenio int,
data_e_hora datetime NOT NULL UNIQUE,
valor decimal(9,2) NOT NULL,
carteira_convenio varchar(45),
especialidade_desejada varchar(45) NOT NULL,
FOREIGN KEY (id_paciente) REFERENCES Pacientes (id),
FOREIGN KEY (id_medico) REFERENCES Médicos (id),
FOREIGN KEY (id_convenio) REFERENCES Convênios (id)
);

CREATE TABLE Receitas(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_consulta int NOT NULL UNIQUE,
medicamento_nome varchar(45) NOT NULL,
medicamento_quantidade varchar(45) NOT NULL,
instrucoes varchar(200) NOT NULL,
FOREIGN KEY (id_consulta) REFERENCES Consultas (id)
);

CREATE TABLE Especialidades(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome varchar(45) NOT NULL
);

CREATE TABLE Médicos_Especialidades(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
Médicos_id int NOT NULL,
Especialidades_id int NOT NULL,
FOREIGN KEY (Médicos_id) REFERENCES Médicos (id),
FOREIGN KEY (Especialidades_id) REFERENCES Especialidades (id)
);

CREATE TABLE Tipo_quarto(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
tipo varchar(45) NOT NULL,
valor_diaria decimal(9,2) NOT NULL,
descricao varchar(200) NOT NULL
);

CREATE TABLE Quarto(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
numero int NOT NULL UNIQUE,
Tipo_quarto_id int NOT NULL,
FOREIGN KEY (Tipo_quarto_id) REFERENCES Tipo_quarto (id)
);

CREATE TABLE Internação(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
data_entrada date NOT NULL,
data_prev_alta date NOT NULL,
data_alta date NOT NULL,
procedimento varchar(200) NOT NULL,
Quarto_id int NOT NULL,
Consulta_id int NOT NULL,
FOREIGN KEY (Quarto_id) REFERENCES Quarto (id),
FOREIGN KEY (Consulta_id) REFERENCES Consultas (id)
);

CREATE TABLE Enfermeiros(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome varchar(45) NOT NULL,
cpf varchar(45) NOT NULL UNIQUE,
cre varchar(45) NOT NULL UNIQUE
);

CREATE TABLE Internação_Enfermeiros(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
Internacao_id int NOT NULL,
Enfermeiros_id int NOT NULL,
FOREIGN KEY (Internacao_id) REFERENCES Internação (id),
FOREIGN KEY (Enfermeiros_id) REFERENCES Enfermeiros (id)
);