USE uc4atividades;

ALTER TABLE cliente
DROP COLUMN nome,
DROP COLUMN endereco,
ADD COLUMN nome VARCHAR(20) NOT NULL,
ADD COLUMN sobrenome VARCHAR(20) NOT NULL;

CREATE TABLE endereço (
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
rua VARCHAR(100) NOT NULL,
numero INT NOT NULL,
cliente_id INT NOT NULL,
FOREIGN KEY (cliente_id) REFERENCES cliente (id)
);

ALTER TABLE item_venda
DROP COLUMN nome_produto,
DROP COLUMN valor_unitario,
DROP COLUMN subtotal;

ALTER TABLE produto
ADD COLUMN valor_unitario DECIMAL(9,2) NOT NULL;

CREATE VIEW subtotal_item_venda AS
SELECT quantidade, produto.valor_unitario,
(quantidade * produto.valor_unitario) AS subtotal
FROM item_venda
JOIN produto;

ALTER TABLE venda
DROP COLUMN valor_total,
DROP COLUMN tipo_pagamento,
DROP COLUMN numero_cartao_pagamento,
DROP COLUMN numero_parcelas_pagamento,
DROP COLUMN data_pagamento;

CREATE TABLE pagamento(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
tipo VARCHAR(1) NOT NULL,
numero_cartao INT NOT NULL,
numero_parcelas INT NOT NULL,
venda_id INT NOT NULL,
FOREIGN KEY (venda_id) REFERENCES venda (id)
);

CREATE VIEW valor_total AS
SELECT * FROM subtotal_item_venda;