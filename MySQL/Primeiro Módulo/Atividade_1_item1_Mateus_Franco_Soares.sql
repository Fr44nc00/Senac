DROP USER IF EXISTS 'user_relatorio'@'uc4atividades';
CREATE USER 'user_relatorio'@'uc4atividades' IDENTIFIED BY '125689';

GRANT SELECT ON *.* TO 'user_relatorio'@'uc4atividades';