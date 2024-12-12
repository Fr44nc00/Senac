SELECT SUM(iv.subtotal), SUM(iv.quantidade)
FROM produto p, item_venda iv, venda v, cliente c
WHERE p.id = iv.produto_id AND v.id = iv.venda_id AND c.id = v.cliente_id
GROUP BY c.nome, p.nome;

 /***
Usando EXPLAIN na consulta
**/

EXPLAIN SELECT SUM(iv.subtotal), SUM(iv.quantidade)
FROM produto p, item_venda iv, venda v, cliente c
WHERE p.id = iv.produto_id AND v.id = iv.venda_id AND c.id = v.cliente_id
GROUP BY c.nome, p.nome;

/***
Criando duas INDEX pra facilitar a consulta
**/

CREATE INDEX idx_nome ON produto(nome);

/***
Simplificando a consulta com JOINs
**/

SELECT SUM(item_venda.subtotal), SUM(item_venda.quantidade)
FROM produto
JOIN item_venda ON produto.id = item_venda.produto_id
JOIN venda ON venda.id = item_venda.venda_id
JOIN cliente ON cliente.id = venda.cliente_id
GROUP BY cliente.nome, produto.nome;

/***
Explicando a consulta modificada
**/

EXPLAIN SELECT SUM(item_venda.subtotal), SUM(item_venda.quantidade)
FROM produto
JOIN item_venda ON produto.id = item_venda.produto_id
JOIN venda ON venda.id = item_venda.venda_id
JOIN cliente ON cliente.id = venda.cliente_id
GROUP BY cliente.nome, produto.nome;

/***
Criando uma VIEW da consulta
**/

CREATE VIEW relatorio_produto AS 
SELECT SUM(item_venda.subtotal), SUM(item_venda.quantidade)
FROM produto
JOIN item_venda ON produto.id = item_venda.produto_id
JOIN venda ON venda.id = item_venda.venda_id
JOIN cliente ON cliente.id = venda.cliente_id
GROUP BY cliente.nome, produto.nome;