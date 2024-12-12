SELECT * FROM produto p, item_venda iv, venda v
WHERE p.id = iv.produto_id AND v.id = iv.venda_id AND p.fabricante like '%lar%';
 
 /***
Usando EXPLAIN na consulta
**/

EXPLAIN SELECT * FROM produto p, item_venda iv, venda v
WHERE p.id = iv.produto_id AND v.id = iv.venda_id AND p.fabricante like '%lar%';

/***
Criando uma INDEX pra facilitar a consulta
**/

CREATE INDEX idx_fabricante ON produto(fabricante DESC);

/***
Simplificando a consulta com JOINs
**/

SELECT * FROM produto
JOIN item_venda ON produto.id = item_venda.produto_id
JOIN venda ON venda.id = item_venda.venda_id
WHERE fabricante like '%lar%'
ORDER BY produto_nome;

/***
Explicando a consulta modificada
**/

EXPLAIN SELECT * FROM produto
JOIN item_venda ON produto.id = item_venda.produto_id
JOIN venda ON venda.id = item_venda.venda_id
WHERE fabricante like '%lar%'
ORDER BY produto_nome;

/***
Criando uma VIEW da consulta
**/

CREATE VIEW view_fabricante_específico AS
SELECT produto.fabricante AS fabricante,
item_venda.produto_id AS item_venda_produto_id,
venda.id AS venda_id
FROM produto
JOIN item_venda ON produto.id = item_venda.produto_id
JOIN venda ON venda.id = item_venda.venda_id
WHERE fabricante like '%lar%'
ORDER BY produto_nome;
