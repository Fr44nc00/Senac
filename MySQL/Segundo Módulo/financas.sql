/*drop database financas;*/
create database financas;

use financas;

create table despesa(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(100),
	valor NUMERIC(5, 2),
	data DATE
);

CREATE TABLE conta (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    banco VARCHAR(100)
    );
    
  CREATE TABLE receita(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(100),
    valor DECIMAL(5,2),
    conta_id int,
    data DATE,
    FOREIGN KEY (conta_id) REFERENCES conta(id)
    ); 

use financas;
select * from despesa;