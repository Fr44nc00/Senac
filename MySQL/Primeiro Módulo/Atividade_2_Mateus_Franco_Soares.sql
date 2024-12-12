use uc4atividades;

DELIMITER //
DROP PROCEDURE IF EXISTS lista_compras;
CREATE PROCEDURE lista_compras (
    IN id_cliente INT,
    IN data_inicial DATETIME,
    IN data_final DATETIME
)
BEGIN
    SET data_inicial = DATE_SUB(data_inicial, INTERVAL 1 DAY);
    SET data_final = DATE_ADD(data_final, INTERVAL 1 DAY);
    
    SELECT nome, venda.id, venda.valor_total, item_venda.nome_produto, item_venda.quantidade
        FROM cliente
        JOIN venda ON id_cliente = venda.cliente_id
        JOIN item_venda ON venda_id = venda.id
	WHERE cliente.id = id_cliente AND data BETWEEN data_inicial AND data_final;
    
END//
DELIMITER ;

CALL lista_compras (1,'20000101','20220203');

DELIMITER //
DROP FUNCTION IF EXISTS tipo_cliente;
CREATE FUNCTION tipo_cliente(
id_cliente INT
) RETURNS VARCHAR(255) DETERMINISTIC
BEGIN
    DECLARE total_compras DECIMAL(10, 2);
    DECLARE status_cliente VARCHAR(255);
    SET total_compras = (
        SELECT SUM(venda.valor_total)
        FROM venda
        WHERE venda.cliente_id = id_cliente
    );

    IF total_compras > 10000 THEN
        SET status_cliente = 'PREMIUM';
    ELSEIF total_compras < 10000 THEN
        SET status_cliente = 'REGULAR';
    END IF;
    
    RETURN status_cliente;
END //
DELIMITER ;

SELECT tipo_cliente (1);

DELIMITER //
DROP TRIGGER IF EXISTS nova_senha;
CREATE TRIGGER nova_senha BEFORE INSERT ON usuario
FOR EACH ROW
BEGIN
    SET NEW.senha = MD5(NEW.senha);
END //
DELIMITER ;

INSERT INTO usuario (id, login, senha, ultimo_login) VALUES
(12, 'fr44nc00','simone04','2022-01-10 10:00:00');

SELECT * FROM usuario WHERE id = 12;