/*DROP DATABASE IF EXISTS sorveteria;*/
CREATE DATABASE sorveteria;
USE sorveteria;

CREATE TABLE Usuario(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
login VARCHAR(45),
senha VARCHAR(45),
cpf VARCHAR(14),
telefone DOUBLE,
tipoUsu VARCHAR(45),
nomeCompleto VARCHAR(100)
);

CREATE TABLE Produto(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome VARCHAR(100),
descricao VARCHAR(255),
quantidade VARCHAR(100),
preco DOUBLE(9,2)
);

INSERT INTO Usuario
(login,senha,cpf,telefone,tipoUsu,nomeCompleto) VALUES
('fr4nc0','simone04','168.688.917-84',21980177497,'Gerente','Mateus Franco Soares'),
('m44nu33l44','simone04','757.373.080-22',2122745767,'Cliente','Manuela Franco Soares'),
('lauratopgun','amootomcruise','913.720.410-60',2127836839,'Funcionário','Laura Bento de Oliveira Faria');

INSERT INTO Produto
(nome,descricao,quantidade,preco) VALUES
('Limão','Sorvete sabor limão','5 litros',10.0),
('Chocolate','Sorvete sabor chocolate','1 litro',15.0),
('Morango','Sorvete sabor morango','2 litros',15.0),
('Coco','Sorvete sabor coco','5 litros',10.0),
('Baunilha','Sorvete sabor baunilha','0,5/meio litro',20.0),
('Chiclete','Sorvete sabor chiclete','4 litros',12.0),
('Granulado','Granulados para acompanhamento','1 quilo',0.5);