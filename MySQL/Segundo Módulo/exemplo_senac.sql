-- Comentário de única linha
/*
Comentários
de
mais
de
uma
linha
*/

drop database if exists exemplo_senac; -- deletando banco de dados
create database exemplo_senac; -- criando banco de dados
Use exemplo_senac; -- deve ser declarado ao usar um banco de dados

create table usuario( -- criando tabela
    id int not null auto_increment,
    nome varchar(70),
    PRIMARY KEY (id)
);

INSERT INTO usuario (nome) VALUES ('João'); -- insere dados em uma parte da tabela
INSERT INTO usuario (nome) VALUES ('Pedro');
INSERT INTO usuario (nome) VALUES ('Maria');
SELECT * FROM usuario; -- consulta uma tabela do banco
-- Também é possível consultar apenas uma coluna da tabela usando "SELECT nome FROM usuario"
UPDATE usuario SET nome = 'João da Silva' WHERE id = 1; -- atualizando dados já existentes numa tabela
-- deletando dados de uma tabela: DELETE FROM usuario WHERE id = 1;
