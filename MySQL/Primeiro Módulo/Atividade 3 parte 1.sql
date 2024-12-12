USE hospital_db_leandro_leao;
SHOW TABLES;
INSERT INTO tipo_quarto
(descricao,valor_diaria) VALUES
('apartamentos','150'),
('quartos duplos','100'),
('enfermaria','50');
SELECT * FROM tipo_quarto;
INSERT INTO convenio
(nome,cnpj,tempo_carencia) VALUES
('MedMais','53.938.648/0001-70','30 Dias'),
('UniSaude','43.014.456/0001-13','14 Dias'),
('Pro Health','38.062.478/0001-19','10 Dias'),
('Minas Med','72.173.260/0001-70','5 Dias');
SELECT * FROM convenio;
INSERT INTO especialidades
(nome) VALUES
('Pediatria'),
('Clínico geral'),
('Gastroenterologia'),
('Dermatologia'),
('Oftamologia'),
('Ginecologia'),
('Cardiologia');
SELECT * FROM especialidades;
INSERT INTO medicos
(nome,data_nascimento,cpf,endereco,UF,crm,telefone) VALUES
('Anny Quintanilha','1970-11-10','86132473009','Rua Flores 10, apto 101','RS','120935','(69) 3752-5488'),
('Suéli Simão Pegado','1990-08-27','62876978067','Avenida Japão 50','SP','15891','(97) 2810-2734'),
('Alisson Sacramento','1981-01-15','80814279023','Rua Albieri 480','MG','178105','(79) 2718-0264'),
('Lívia Veloso','1972-03-22','20924987030','Rua Travessa A 89','MG','17897','(61) 3019-1483'),
('Gael Milheiro Lemes','1964-02-13','38603737061','Rua das Rosas, 80, apto 200','RS','9826','(82) 2433-7762'),
('Gisela Espinosa','1980-09-12','23529091049','Avenida Santos, 90','SP','34548','(86) 3368-4812'),
('Nelson Anjos Palmeira','1980-10-14','03626639045','Rua Álamo, 180, ap 90','SP','344789','(54) 3941-4795'),
('Ezequiel Pestana Henriques','1979-06-30','67297959057','Avenida Chateaubriand, 150','RS','9756','(69) 2537-6076'),
('Tito Carqueijeiro','1973-05-19','74588651056','Rua Flores 670','RS','14777','(83) 3272-8326'),
('Fabiano Gomide','1989-08-31','32972518080','Avenida das Águas 600','RS','65765','(63) 3230-5071'),
('Cristovão Xavier','1979-12-12','92690490005','Rua da Luz, 80','RS','67432','(24) 2448-9465'),
('Alberto Veríssimo','1986-06-26','70600178013','Avenida  das aves, 9912, apto 60','SP','13548','(67) 3754-8886'),
('Júlia Camarinho','1980-07-05','74492596054','Rua Albieri 590','MG',24654,'(61) 2615-4776');
SELECT * FROM medicos;
INSERT INTO medicos_especialidades
(medico_id, especialidade_id) VALUES
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
SELECT * FROM medicos_especialidades;
INSERT INTO pacientes
(nome,cpf,data_nascimento,endereco,telefone,email,RG) VALUES
('Karine Macena Porciúncula','17025458066','1944-05-17','Avenida Brasil Leste 605','(54)986580917','melissa-lima88@techdomus.com.br','454623884'),
('Zilda Gomide Osório','90372646549','1971-02-13','Rua Jornalista Amaro de Figueiredo Falcão 689','(65)39842771','elzabrendanovaes@pierproj.com.br','493719556'),
('César Sítima Faria','64658103796','1958-02-13','Rua 170 apto 143','(92)987129216','manoel_vinicius_alves@cedda.com.br','134796524'),
('Silvana Fartaria Nazário','25815674575','1994-01-09','Rua Darcy Coelho de Oliveira 549','(31)986170324','yago_edson_rodrigues@hushmail.com','245852888'),
('Evandro Trindade Bouça','36503482337','1953-01-11','Rua Maria do Carmo de Souza 1000','(84)993530046','raul_drumond@gameecia.com.br','120470135'),
('Ivo Brandão Palos','08680059323','1973-04-23','Rua Almirante Tamandaré 897','(51)991282157','mirellafabianadapaz@abdalathomaz.adv.br','125976914'),
('Armindo Moreira Azeredo','86140120470','1984-03-10','Avenida Rui Barbosa 802','(41)995916500','otavio-campos77@aguabr.com.br','361542422'),
('Mark Festas Santana','66471055730','1974-03-12','Rua Verbenas 874','(92)989501843','carolina.luciana.cardoso@sdrifs.com.br','140213879'),
('Helton Espinosa','64091362346','1998-01-15','2ª Travessa Osvaldo Cruz 201','(82)999122823','benjaminrobertonogueira@oi15.com.br','181798190'),
('Giovanni Arouca Mata','96025659265','1991-02-06','Quadra 7 426','(61)982534892','samuel_thiago_pires@tlmix.com.br','131521883');
SELECT * FROM pacientes;
INSERT INTO medicamentos
(nome,dosagem,fabricante) VALUES
('Topiramato','200 mg','Aché'),
('Nimesulida','50 mg','BioLab'),
('Dipirona','20/40 gotas','NeoQuimica'),
('Novalgina','22,3 mg','EuroFarma'),
('Dorflex','2 comprimidos','Bayer');
SELECT * FROM medicamentos;
INSERT INTO consultas
(data_hora,valor,paciente_id,medico_id,convenio_id,medicamento_id) VALUES
('2019-02-06 09:20:00','110.90',1,13,4,3),
('2019-02-16 09:10:00','110.90',2,3,1,5),
('2019-04-04 09:20:00','180.00',3,2,2,1),
('2019-07-20 12:10:00','180.00',4,5,3,4),
('2019-08-03 15:20:00','150.00',5,9,2,3),
('2019-10-14 09:20:00','75.00',6,8,2,NULL),
('2019-11-01 08:10:00','150.00',7,1,4,NULL),
('2019-11-05 15:10:00','100.00',8,4,3,NULL),
('2020-05-18 09:10:00','120.00',9,10,4,NULL),
('2020-07-16 08:10:00','110.90',10,11,2,NULL);
SELECT * FROM consultas;
INSERT INTO quarto
(numero,tipo_quarto_id) VALUES
(101,1),
(102,1),
(103,2),
(104,2),
(105,3),
(106,3);
SELECT * FROM quarto;
INSERT INTO internacao
(data_entrada,data_prev_alta,data_alta,procedimento,quarto_id,paciente_id) VALUES
('2017-11-25','2017-11-28','2017-11-29','Cirurgia de apendicite',1,7),
('2018-03-15','2018-03-18','2018-03-19','Tratamento Pneumonia',3,6),
('2018-08-12','2018-08-15','2018-08-16','Cirurgia adenoide',2,1),
('2019-06-05','2019-06-08','2019-06-09','Tratamento Dengue',5,7),
('2020-02-10','2020-02-13','2020-02-14','Cirurgia Amígdala',4,2),
('2021-04-05','2021-04-08','2021-04-09','Observaçâo',6,6),
('2022-09-01','2022-09-04','2022-09-05','Tratamento catapora',4,3);
SELECT*FROM internacao;
INSERT INTO enfermeiro
(nome,cpf,cre) VALUES
('Renan Enzo Lucas Farias','89583548871','123654'),
('Ester Isabel Barbosa','15415780823','654123'),
('Elisa Benedita Clara Drumond','43856891641','456321'),
('Enrico Ian Manoel Viana','40203830067','987623'),
('Bernardo Gustavo Osvaldo Moura','14088526244','728364'),
('José Mateus Mário Castro','62268313832','127653');
SELECT * FROM enfermeiro;
INSERT INTO internacao_enfermeiro
(enfermeiro_id,internacao_id) VALUES
(1,1),
(1,7),
(2,3),
(2,1),
(3,3),
(3,7),
(4,2),
(4,5),
(5,5),
(5,6),
(6,2),
(6,6),
(1,4),
(5,4);
SELECT * FROM internacao_enfermeiro;


































