DROP USER IF EXISTS 'user_funcionario'@'uc4atividades';
CREATE USER 'user_funcionario'@'uc4atividades' IDENTIFIED BY '235689';

GRANT SELECT, INSERT, UPDATE, DELETE ON uc4atividades.venda TO 'user_funcionario'@'uc4atividades';

GRANT SELECT, INSERT, UPDATE, DELETE ON uc4atividades.cliente TO 'user_funcionario'@'uc4atividades';

GRANT SELECT, INSERT, UPDATE, DELETE ON uc4atividades.produto TO 'user_funcionario'@'uc4atividades';