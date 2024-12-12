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

INSERT INTO Convênios
(nome,cnpj,tempo_carencia) VALUES
('Pro Health','89583891000160','5 meses'),
('UniSaúde','36225903000118','3 meses'),
('MedMais','43885665000132','2 meses'),
('BrasaMed','35450152000170','7 meses'),
('Sem convênio','0','');

INSERT INTO Tipo_quarto
(tipo,valor_diaria,descricao) VALUES
('Apartamentos','100.00','Cama de casal, banheiro, um armário, um frigobar, televisão por antena'),
('Quartos duplos','300.00','Duas camas de solteiro, dois banheiros, dois armários, dois frigobares, televisão por antena'),
('Enfermaria','80.00','Maca, sofá, banheiro, um armário, televisão por antena');

INSERT INTO Especialidades
(nome) VALUE
('Pediatra'),
('Clínico geral'),
('Gastroenterologia'),
('Dermatologia'),
('Ginecologista'),
('Psiquiatria'),
('Cardiologia');

INSERT INTO Pacientes
(nome,cpf,data_nasc,endereco_completo,telefone,email,rg) VALUES
('Karine Macena Porciúncula','563.041.884-04','2005-10-01','Rua Almeida, 80','(21) 2911-7275','mihopo3261@aramask.com','30.349.229-6'),
('Zilda Gomide Osório','834.499.177-30','1990-11-03','Avenida Ametista, 90, apto 102','(22) 2247-3216','tehavis201@byorby.com','46.116.219-2'),
('Fabrício Norões Xavier','151.420.659-56','2005-12-05','Avenida Rubi, 190','(21) 3394-3561','jiayi4134@uorak.com','15.424.862-9'),
('César Sítima Faria','113.415.783-56','1991-01-07','Rua Almeida, 100','(22) 2377-0453','liyiw21018@byorby.com','34.127.791-5'),
('Silvana Fartaria Nazário','152.383.638-50','2005-02-09','Avenida Cravo, 210','(22) 2163-7881','mijibod502@byorby.com','17.244.976-5'),
('Evandro Trindade Bouça','735.257.434-40','1991-03-11','Rua Diamante, 100','(21) 3426-7543','lepofeh448@bodeem.com','25.810.789-3'),
('Ivo Brandão Palos','968.762.475-20','1991-04-13','Rua Esmeralda, 23','(24) 2891-7581','harap62944@aramask.com','25.954.485-1'),
('Armindo Moreira Azeredo','452.436.827-21','1991-05-15','Rua Diamante, 200','(22) 2974-6461','wavayis608@byorby.com','15.712.067-3'),
('Mark Festas Santana','716.923.014-38','2005-06-17','Avenida Cravo, 100, apto 304','(22) 3107-5856','cejoko3993@camplvad.com','18.528.751-7'),
('Helton Espinosa','143.182.316-31','1991-07-19','Avenida Rubi, 200, apto 203','(22) 2643-4331','tobeha8488@bodeem.com','30.849.753-3');

INSERT INTO Convênios_Pacientes
(Pacientes_id,Convenios_id) VALUES
(2,3),
(3,3),
(1,2),
(7,1),
(9,2),
(8,3),
(10,2);

INSERT INTO Médicos
(nome,cpf,data_nasc,crm,uf_crm,telefone,endereco_completo) VALUES
('Anny Quintanilha','861.324.730-09','1970-11-10','120935','RS','(69) 3752-5488','Rua Flores, 10, apto 101'),
('Suéli Simão Pegado','628.769.780-67','1990-08-27','15891','SP','(97) 2810-2734','Avenida Japão, 50'),
('Alisson Sacramento','808.142.790-23','1981-01-15','178105','MG','(79) 2718-0264','Rua Albieri 480'),
('Lívia Veloso','209.249.870-30','1972-03-22','17897','MG','(61) 3019-1483','Travessa A, 89'),
('Gael Milheiro Lemes','386.037.370-61','1964-02-13','9826','RS','(82) 2433-7762','Rua das Rosas, 80, apto 200'),
('Gisela Espinosa','235.290.910-49','1980-09-12','34548','SP','(86) 3368-4812','Avenida Santos, 90'),
('Nelson Anjos Palmeira','036.266.390-45','1980-10-14','344789','SP','(54) 3941-4795','Rua Álamo, 180, apto 90'),
('Ezequiel Pestana Henriques','672.979.590-57','1979-06-30','9756','RS','(69) 2537-6076','Avenida Chateaubriand, 150'),
('Tito Carqueijeiro','745.886.510-56','1973-05-19','14777','RS','(83) 3272-8326','Rua Flores, 670'),
('Fabiano Gomide','329.725.180-80','1989-08-31','65765','RS','(63) 3230-5071','Avenida das Águas, 600'),
('Cristovão Xavier','926.904.900-05','1979-12-12','67432','RS','(24) 2448-9465','Rua da Luz, 80'),
('Alberto Veríssimo','706.001.780-13','1986-06-26','13548','SP','(67) 3754-8886','Avenida  das aves, 9912, apto 60'),
('Júlia Camarinho','744.925.960-54','1980-07-05','24654','MG','(61) 2615-4776','Rua Albieri, 590');

INSERT INTO Consultas
(id_paciente,id_medico,id_convenio,data_e_hora,valor,carteira_convenio,especialidade_desejada) VALUES
(1,13,2,'2019-02-06 09:20:00','110.90','0','Geral'),
(2,3,3,'2019-02-16 09:10:00','110.90','55643215','Gastroenterologia'),
(1,12,2,'2019-03-01 09:20:00','110.90','0','Pediatria'),
(3,13,3,'2019-04-04 09:20:00','180.00','21484234','Gastroenterologia'),
(3,3,3,'2019-05-24 11:10:00','150.00','0','Gastroenterologia'),
(4,2,5,'2019-07-02 16:10:00','110.90','0','Geral'),
(5,5,5,'2019-07-20 12:10:00','180.00','0','Dermatologia'),
(6,9,5,'2019-08-03 15:20:00','150.00','0','Geral'),
(1,3,2,'2019-08-05 16:10:00','110.90','12341234','Gastroenterologia'),
(7,8,1,'2019-10-14 09:20:00','75.00','12342342','Pediatra');

INSERT INTO Receitas
(id_consulta,medicamento_nome,medicamento_quantidade,instrucoes) VALUES
(2,'Leite de magnésio e omeprazol','2 frascos (leite), 1 caixa (Omeprazol)','1 colher de sopa (15 ml) do leite de magnésio por dia durante 3 dias e 1 comprimido de Omeprazol por dia durante 4 semanas.'),
(3,'Novalgina e Paracetamol', '1 frasco (Novalgina), 1 caixa (Paracetamol)','1 copinho de 10 ml de novalgina por dia por uma semana e 2 comprimidos de paracetamol a cada 4 horas durante um período de 24 horas.'),
(7,'Allegra e Loratamed','1 caixa (60mg,Allegra), 1 caixa (Loratamed)','1 comprimido de Allegra de 12 em 12 horas por uma semana, 1 comprimido de Loratamed por dia por uma semana.'),
(9,'Leite de magnésio e omeprazol','2 frascos do leite e 1 frasco de Omeprazol','1 colher de sopa (15 ml) do leite de magnésio por dia durante 3 dias e 1 comprimido de Omeprazol por dia durante 4 semanas.'),
(10,'Novalgina e Paracetamol', '1 frasco (Novalgina), 1 caixa (Paracetamol)','1 copinho de 10 ml de novalgina por dia por uma semana e 2 comprimidos de paracetamol a cada 4 horas durante um período de 24 horas.');

INSERT INTO Médicos_Especialidades
(Médicos_id,Especialidades_id) VALUES
(1,1),
(1,2),
(2,2),
(3,3),
(4,1),
(4,3),
(5,4),
(6,2),
(7,1),
(8,1),
(9,2),
(10,2),
(11,4),
(11,1),
(12,1),
(13,3),
(13,2);

INSERT INTO Quarto
(numero,Tipo_quarto_id) VALUES
(101,1),
(102,2),
(103,3),
(104,1),
(105,2),
(106,3);

INSERT INTO Internação
(data_entrada,data_prev_alta,data_alta,procedimento,Quarto_id,Consulta_id) VALUES
('2019-02-06','2019-02-08','2019-02-08','Paciente sentia fortes dores na região do pulmão, após alguns dias de teste foi detectada pneumonia',3,1),
('2019-04-04','2019-04-07','2019-04-07','Paciente sentia-se enjoado constantemente, depois de alguns dias de teste foi detectada virose',6,4),
('2019-05-24','2019-05-30','2019-05-30','Paciente sentia-se enjoado constantemente, depois de alguns dias de teste foi detectada intoxicação alimentar',3,5),
('2019-07-02','2019-07-09','2019-07-09','Paciente sentia-se dores de cabeça intensas, após alguns testes foi detectado burnout',6,6),
('2019-07-20','2019-07-23','2019-07-23','Paciente possuia uma região do braço com irritação, após alguns testes e medicamentos o paciente foi diagnosticado com alergia a gatos',3,7),
('2019-08-03','2019-08-06','2019-08-06','Paciente tinha crises de espirros e febre, após testes foi detectada alergia a sulfa',6,8),
('2019-08-05','2019-08-08','2019-08-08','Paciente sentia-se enjoado constantemente, depois de alguns dias de teste foi detectada virose',3,9);

INSERT INTO Enfermeiros
(nome,cpf,cre) VALUES
('Mateus Franco de Oliveira','711.553.664-33',938464),
('Victor Souza Menezes','530.087.271-74',912911),
('Julia Vitória dos Santos','249.099.814-54',304852),
('Simone Rodrigues Soares','964.311.181-46',286255),
('Pedro de Souza Silva','587.837.352-16',546984),
('Maria Clara dos Santos Faria','611.593.624-16',702420);

INSERT INTO Internação_Enfermeiros
(Internacao_id,Enfermeiros_id) VALUES
(1,1),
(1,2),
(2,1),
(2,3),
(3,2),
(3,4),
(4,3),
(4,5),
(5,6),
(5,4),
(6,1),
(6,6),
(7,2),
(7,5);

ALTER TABLE Médicos 
ADD COLUMN em_atividade BIT;
UPDATE Médicos SET em_atividade = 0 WHERE id IN (1, 2);
UPDATE Médicos SET em_atividade = 1 WHERE id NOT IN (1, 2);

UPDATE Internação
SET data_alta = DATE_ADD(data_entrada, INTERVAL 3 DAY)
WHERE Quarto_id IN (3,6);

SELECT MAX(id) FROM Convênios;
DELETE FROM Consultas WHERE id_convenio = 4;
DELETE FROM Convênios WHERE id = 4;








-- Atividade 4 --

-- Todos os dados e o valor médio das consultas do ano de 2020 realizadas SEM convênio --

/*INSERT INTO Consultas
(id_paciente,id_medico,id_convenio,data_e_hora,valor,carteira_convenio,especialidade_desejada) VALUES
(5,2,5,'2020-07-02 16:10:00','140.90','0','Geral'),
(2,9,3,'2020-08-03 15:20:00','140.00','12342742','Geral'),
(6,8,5,'2020-10-14 09:20:00','95.00','0','Pediatra'),
(3,3,3,'2020-11-05 16:10:00','90.90','12651234','Gastroenterologia');*/
SELECT * FROM Consultas WHERE YEAR(data_e_hora) = 2020 AND id_convenio = 5;
SELECT AVG(valor) FROM Consultas WHERE YEAR(data_e_hora) = 2020 AND id_convenio = 5;

-- Todos os dados e o valor médio das consultas do ano de 2020 realizadas POR convênio --

SELECT * FROM Consultas WHERE YEAR(data_e_hora) = 2020 AND id_convenio <> 5;
SELECT AVG(valor) FROM Consultas WHERE YEAR(data_e_hora) = 2020 AND id_convenio <> 5;

-- Todos os dados das internações que tiveram data de alta maior que a data prevista para a alta --

/*INSERT INTO Internação
(data_entrada,data_prev_alta,data_alta,procedimento,Quarto_id,Consulta_id) VALUES
('2020-07-02','2020-07-06','2020-07-15','Paciente sofreu um impacto na região da testa e possuia tontura e visão turva.',1,11),
('2020-11-05','2020-11-08','2020-11-20','Paciente sentia-se enjoado constantemente, depois de alguns dias de teste foi detectada virose',4,14);*/
SELECT * FROM Internação WHERE data_alta > data_prev_alta;

-- Receituário completo da primeira consulta registrada com receituário associado --

SELECT * FROM Receitas WHERE id_consulta = (SELECT MIN(id_consulta) from Receitas);

-- Todos os dados da consulta de maior valor e também da de menor valor (ambas as consultas não foram realizadas sob convênio) --

SELECT * FROM Consultas WHERE id_convenio = 5
ORDER BY valor DESC
LIMIT 1;
SELECT * FROM Consultas WHERE id_convenio = 5
ORDER BY valor
LIMIT 1;

-- Todos os dados das internações em seus respectivos quartos, calculando o total da internação a partir do valor de diária do quarto e o número de dias entre a entrada e a alta --

/*ALTER TABLE Internação 
ADD COLUMN total_diaria int NOT NULL;
UPDATE Internação SET total_diaria = 100*DATEDIFF(Internação.data_alta,Internação.data_entrada) WHERE Quarto_id IN (1,4);
UPDATE Internação SET total_diaria = 300*DATEDIFF(Internação.data_alta,Internação.data_entrada) WHERE Quarto_id IN (2,5);
UPDATE Internação SET total_diaria = 80*DATEDIFF(Internação.data_alta,Internação.data_entrada) WHERE Quarto_id IN (3,6);*/
SELECT * FROM Internação;

-- Data, procedimento e número de quarto de internações em quartos do tipo “apartamento” --
/*ALTER TABLE Internação
ADD COLUMN numero_quarto int NOT NULL;
UPDATE Internação SET numero_quarto = 101 WHERE Quarto_id IN (1);
UPDATE Internação SET numero_quarto = 102 WHERE Quarto_id IN (2);
UPDATE Internação SET numero_quarto = 103 WHERE Quarto_id IN (3);
UPDATE Internação SET numero_quarto = 104 WHERE Quarto_id IN (4);
UPDATE Internação SET numero_quarto = 105 WHERE Quarto_id IN (5);
UPDATE Internação SET numero_quarto = 106 WHERE Quarto_id IN (6);*/
SELECT Internação.data_entrada,Internação.procedimento,Internação.numero_quarto FROM Internação WHERE Quarto_id IN (1,4);

-- Nome do paciente, data da consulta e especialidade de todas as consultas em que os pacientes eram menores de 18 anos na data da consulta e cuja especialidade não seja “pediatria”, ordenando por data de realização da consulta + nova coluna com nome do paciente --

/*ALTER TABLE Consultas
ADD COLUMN nome_paciente varchar(45) NOT NULL;
UPDATE Consultas SET nome_paciente = 'Karine Macena Porciúncula' WHERE id_paciente IN (1);
UPDATE Consultas SET nome_paciente = 'Zilda Gomide Osório' WHERE id_paciente IN (2);
UPDATE Consultas SET nome_paciente = 'Fabrício Norões Xavier' WHERE id_paciente IN (3);
UPDATE Consultas SET nome_paciente = 'César Sítima Faria' WHERE id_paciente IN (4);
UPDATE Consultas SET nome_paciente = 'Silvana Fartaria Nazário' WHERE id_paciente IN (5);
UPDATE Consultas SET nome_paciente = 'Evandro Trindade Bouça' WHERE id_paciente IN (6);
UPDATE Consultas SET nome_paciente = 'Ivo Brandão Palos' WHERE id_paciente IN (7);
UPDATE Consultas SET nome_paciente = 'Armindo Moreira Azeredo' WHERE id_paciente IN (8);
UPDATE Consultas SET nome_paciente = 'Mark Festas Santana' WHERE id_paciente IN (9);
UPDATE Consultas SET nome_paciente = 'Helton Espinosa' WHERE id_paciente IN (10);
UPDATE Consultas SET especialidade_desejada = 'Pediatria' WHERE id IN (10,13);*/
SELECT Consultas.nome_paciente,Consultas.data_e_hora,Consultas.especialidade_desejada
FROM Consultas WHERE id_paciente IN (SELECT id FROM Pacientes 
WHERE DATEDIFF(Pacientes.data_nasc,Consultas.data_e_hora) < 18) 
AND Consultas.especialidade_desejada <> 'Pediatria'
ORDER BY data_e_hora;

-- Nome do paciente, nome do médico, data da internação e procedimentos das internações realizadas por médicos da especialidade “gastroenterologia”, que tenham acontecido em “enfermaria” --

/*ALTER TABLE Internação
ADD COLUMN nome_paciente varchar(45) NOT NULL,
ADD COLUMN nome_medico varchar(45) NOT NULL;
UPDATE Internação SET nome_paciente = 'Karine Macena Porciúncula' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_paciente IN (1));
UPDATE Internação SET nome_paciente = 'Zilda Gomide Osório' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_paciente IN (2));
UPDATE Internação SET nome_paciente = 'Fabrício Norões Xavier' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_paciente IN (3));
UPDATE Internação SET nome_paciente = 'César Sítima Faria' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_paciente IN (4));
UPDATE Internação SET nome_paciente = 'Silvana Fartaria Nazário' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_paciente IN (5));
UPDATE Internação SET nome_paciente = 'Evandro Trindade Bouça' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_paciente IN (6));
UPDATE Internação SET nome_paciente = 'Ivo Brandão Palos' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_paciente IN (7));
UPDATE Internação SET nome_paciente = 'Armindo Moreira Azeredo' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_paciente IN (8));
UPDATE Internação SET nome_paciente = 'Mark Festas Santana' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_paciente IN (9));
UPDATE Internação SET nome_paciente = 'Helton Espinosa' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_paciente IN (10));
UPDATE Internação SET nome_medico = 'Anny Quintanilha' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_medico IN (1));
UPDATE Internação SET nome_medico = 'Suéli Simão Pegado' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_medico IN (2));
UPDATE Internação SET nome_medico = 'Alisson Sacramento' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_medico IN (3));
UPDATE Internação SET nome_medico = 'Lívia Veloso' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_medico IN (4));
UPDATE Internação SET nome_medico = 'Gael Milheiro Lemes' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_medico IN (5));
UPDATE Internação SET nome_medico = 'Gisela Espinosa' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_medico IN (6));
UPDATE Internação SET nome_medico = 'Nelson Anjos Palmeira' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_medico IN (7));
UPDATE Internação SET nome_medico = 'Ezequiel Pestana Henriques' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_medico IN (8));
UPDATE Internação SET nome_medico = 'Tito Carqueijeiro' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_medico IN (9));
UPDATE Internação SET nome_medico = 'Fabiano Gomide' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_medico IN (10));
UPDATE Internação SET nome_medico = 'Cristovão Xavier' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_medico IN (11));
UPDATE Internação SET nome_medico = 'Alberto Veríssimo' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_medico IN (12));
UPDATE Internação SET nome_medico = 'Júlia Camarinho' WHERE Consulta_id IN (SELECT id FROM Consultas WHERE id_medico IN (13));*/
SELECT nome_paciente,nome_medico,data_entrada,procedimento FROM Internação
WHERE Consulta_id IN (SELECT id FROM Consultas WHERE especialidade_desejada = 'Gastroenterologia')
AND Quarto_id IN (3,6);

-- Os nomes dos médicos, seus CRMs e a quantidade de consultas que cada um realizou --

SELECT Médicos.nome, Médicos.crm, COUNT(Consultas.id) AS quantidade_consultas
FROM Médicos
JOIN Consultas ON Médicos.id = Consultas.id_medico
GROUP BY Médicos.nome, Médicos.crm;

-- Os nomes, CREs e número de internações de enfermeiros que participaram de mais de uma internação --

SELECT Enfermeiros.nome, Enfermeiros.cre, 
COUNT(Internação_Enfermeiros.Enfermeiros_id) AS numero_internacoes
FROM Enfermeiros
JOIN Internação_Enfermeiros ON Enfermeiros.id = Internação_Enfermeiros.Enfermeiros_id
GROUP BY Enfermeiros.nome,Enfermeiros.cre
HAVING COUNT(Internação_Enfermeiros.Enfermeiros_id) > 1;



-- Consultar as internações feitas pelo primeiro enfermeiro registrado no sistema --

SELECT * FROM Internação WHERE id IN (SELECT Internacao_id FROM Internação_Enfermeiros WHERE Enfermeiros_id IN (1))