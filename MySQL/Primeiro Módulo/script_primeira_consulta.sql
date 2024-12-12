SELECT * FROM venda v, item_venda iv, produto p, cliente c, funcionario f
WHERE v.id = iv.venda_id AND c.id = v.cliente_id AND p.id = iv.produto_id AND f.id = v.funcionario_id and tipo_pagamento = 'D';

/***
Usando EXPLAIN na consulta
**/

EXPLAIN SELECT * FROM venda v, item_venda iv, produto p, cliente c, funcionario f
WHERE v.id = iv.venda_id AND c.id = v.cliente_id AND p.id = iv.produto_id AND f.id = v.funcionario_id and tipo_pagamento = 'D';

/***
Criando uma INDEX pra facilitar a consulta
**/

CREATE INDEX idx_tipo_pagamento ON venda(tipo_pagamento);

/***
Simplificando a consulta com JOINs
**/

SELECT * FROM venda
JOIN item_venda ON venda.id = item_venda.venda_id
JOIN cliente ON cliente.id = venda.cliente_id
JOIN produto ON produto.id = item_venda.produto_id
JOIN funcionario ON funcionario.id = venda.funcionario_id
WHERE tipo_pagamento = 'D'
ORDER BY data DESC;

/***
Explicando a consulta modificada
**/

EXPLAIN SELECT * FROM venda
JOIN item_venda ON venda.id = item_venda.venda_id
JOIN cliente ON cliente.id = venda.cliente_id
JOIN produto ON produto.id = item_venda.produto_id
JOIN funcionario ON funcionario.id = venda.funcionario_id
WHERE tipo_pagamento = 'D'
ORDER BY data DESC;

/***
Criando uma VIEW da consulta
**/

CREATE VIEW view_vendas_dinheiro AS
SELECT venda.tipo_pagamento AS tipo_pagamento,
item_venda.venda_id AS venda_id,
cliente.id AS cliente_id,
produto.id AS produto_id,
funcionario.id AS funcionario_id 
FROM venda
JOIN item_venda ON venda.id = item_venda.venda_id
JOIN cliente ON cliente.id = venda.cliente_id
JOIN produto ON produto.id = item_venda.produto_id
JOIN funcionario ON funcionario.id = venda.funcionario_id
WHERE venda.tipo_pagamento = 'D'
ORDER BY data DESC;