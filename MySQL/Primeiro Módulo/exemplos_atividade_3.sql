DROP DATABASE IF EXISTS Eventos;
CREATE DATABASE Eventos;
USE Eventos;
CREATE TABLE participantes(
    idParticipante INT (9) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200),
    dt_nasc DATE,
    genero VARCHAR(2),
    logradouro VARCHAR(200),
    bairro VARCHAR(200),
    cidade VARCHAR(200),
    complemento VARCHAR(200),
    uf VARCHAR(2),
    cep VARCHAR(200),
    comunidade VARCHAR(200),
    participa VARCHAR(1),
    movimento VARCHAR(1),
    escola VARCHAR(200),
    sabendo VARCHAR(200)
);

INSERT INTO participantes(
    nome, dt_nasc, genero, logradouro, bairro, cidade, complemento, uf, cep, 
    comunidade, participa, movimento, escola, sabendo
) VALUES (
    "Amanda", "2000-10-10", "F", "Rua das Andradas", "Centro", "Porto Alegre", "Final da rua",
    "RS", "911111000", "Do bairro", "S", "S", "Dom Francisco", "Internet"),
    ("Ricardo", "2000-10-10", "M", "Rua das Nereidas", "Centro", "Porto Alegre", "Bloco C",
    "RS", "911000000", "Do bairro", "S", "S", "João XXIII", "Internet"),
    ("Amadeu", "2010-05-20", "M", "Rua Gal Osório", "Porto", "Porto Alegre", "Bloco C",
    "RS", "911009999", "Do bairro", "N", "N", "João XXIII", "Revista"),
    ("Teobaldo", "1995-05-01", "M", "Rua Félix da Cunha", "Partenon", "Porto Alegre", "Casa 2",
    "RS", "900009999", "Do bairro", "N", "N", "Dohms", "Jornal"),
    ("Cremilda", "1980-05-01", "F", "Rua Silvério Souto", "Teresópolis", "Porto Alegre", "Casa 2",
    "RS", "946309999", "Do bairro", "N", "N", "Padre Pio", "Internet"
);

Select * from participantes;

CREATE VIEW view_participante AS SELECT * FROM participantes;

SHOW TABLES;

SELECT * FROM VIEW_PARTICIPANTE;

CREATE VIEW view_participante2 AS SELECT nome, cidade, escola FROM participantes;
Select * from view_parcipante2;
Select nome from view_parcipante2;

DROP DATABASE IF EXISTS Agencia;
CREATE DATABASE Agencia;
USE Agencia;
CREATE TABLE Usuario (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR (128),
    login VARCHAR (128),
    senha VARCHAR (128),
    datanascimento DATETIME NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE Destino (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR (128),
    origem VARCHAR (128),
    destino VARCHAR (128),
    atrativos VARCHAR (1024),
    saida DATETIME NOT NULL,
    retorno DATETIME NOT NULL,
    id_usuario INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario) REFERENCES Usuario (id)
);

INSERT INTO Usuario (nome, login, senha, datanascimento)
VALUES 
('Ana', 'Ana', '123', '2000-10-10'),
('João', 'João', '123', '1995-05-05'),
('Tiburcio','Tiburcio','123','1975-02-23');

INSERT INTO Destino (nome, origem, destino, atrativos, saida, retorno, id_usuario)
VALUES (
'Rio de Janeiro', 'Curitiba', 'Rio de Janeiro', 'Cidade Maravilhosa', '2022-02-20', '2022-02-28', 2);
INSERT INTO Destino (nome, origem, destino, atrativos, saida, retorno, id_usuario)
VALUES (
'Londres', 'Curitiba', 'Londres', 'Cidade Inglesa', '2022-02-20', '2022-02-28', 1 );
INSERT INTO Destino (nome, origem, destino, atrativos, saida, retorno, id_usuario)
VALUES (
'Nova Zelandia', 'Curitiba', 'Londres', 'Ilha turistica', '2022-02-20', '2022-02-28', 3);

SELECT * FROM DESTINO;

SELECT * FROM USUARIO;

SELECT D.nome AS Pacote, D.Destino AS Cidade, U.Nome AS responsavel
FROM Destino AS D
INNER JOIN Usuario AS U
ON D.ID_usuario = U.ID;

CREATE VIEW VIAGEM AS 
SELECT D.nome AS Pacote, D.destino AS Cidade, U.nome AS responsável 
FROM destino AS D
INNER JOIN Usuario AS U
ON D.ID_Usuario = U.ID;

SELECT * FROM VIAGEM;

ALTER VIEW nome_VIEW AS SELECT * FROM nome_outra_tabela;

DROP DATABASE IF EXISTS Exemplo;
CREATE DATABASE Exemplo;
USE Exemplo;

CREATE TABLE Editora 
(
    Id SMALLINT PRIMARY KEY AUTO_INCREMENT,
    NomeEditora VARCHAR(40) NOT NULL,
    INDEX (NomeEditora)
);

CREATE TABLE cliente
(
    Id	INT,
    Nome	Varchar(50)
);

CREATE INDEX idx_id ON cliente(Id);

DROP DATABASE IF EXISTS Exemplo;
CREATE DATABASE Exemplo;
USE Exemplo;

CREATE TABLE Editora 
(
    Id SMALLINT PRIMARY KEY AUTO_INCREMENT,
    NomeEditora VARCHAR(40) NOT NULL
);

CREATE INDEX idx_NomeEditora ON Editora(NomeEditora);

CREATE INDEX idx_NomeEditora ON Editora(NomeEditora DESC);

SHOW INDEX FROM Cliente;

SHOW INDEX FROM Editora;

DROP INDEX idx_NomeEditora ON Editora;

DROP DATABASE IF EXISTS Exemplo;
CREATE DATABASE Exemplo;
USE Exemplo;

CREATE TABLE Editora (
    Id SMALLINT PRIMARY KEY AUTO_INCREMENT,
    NomeEditora VARCHAR(40) NOT NULL
);

INSERT INTO Editora (NomeEditora)
VALUES 
('Senac'),
('Mc Graw-Hill'),
('Apress'),
('Bookman'),
('Bookboon'),
('Packtpub'), 
('O´Reilly'),
('Springer'),
('Érica'),
('For Dummies'),
('Novatec'),
('Microsoft Press'),
('Cisco Press'),
('Addison-Wesley'),
('Companhia das Letras'),
('Artech House'),
('Wiley'),
('CRC Press'),
('Manning'),
('Penguin Books'),
('Sage Publishing');

SELECT * FROM Editora;

SELECT * FROM Editora WHERE NomeEditora = 'Wiley';

EXPLAIN SELECT * FROM Editora WHERE NomeEditora = 'Wiley';

CREATE INDEX idx_NomeEditora ON Editora(NomeEditora);

EXPLAIN SELECT * FROM Editora WHERE NomeEditora = 'Wiley';