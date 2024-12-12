CREATE DATABASE exemplojavabd;

USE exemplojavabd;
CREATE TABLE `empresa` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`nomeempresa` varchar(50) NOT NULL,
	`areaatuacao` varchar(50) NOT NULL,
	PRIMARY KEY (id)
);

USE exemplojavabd;
CREATE TABLE `funcionario` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `nomefunc` varchar(100) NOT NULL,
    `empresaid` int(11) NOT NULL,
  PRIMARY KEY (id)
  );
  
  ALTER TABLE `funcionario` ADD CONSTRAINT `fk_empresa` FOREIGN KEY 
  (`empresaid`) REFERENCES `empresa`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
  
  ALTER TABLE funcionario ADD admissao date;