ALTER TABLE medicos ADD COLUMN em_atividade BIT;
UPDATE medicos SET em_atividade = 0 WHERE id IN (1, 2);
UPDATE medicos SET em_atividade = 1 WHERE id NOT IN (1, 2);
SELECT * FROM medicos;

UPDATE internacao
SET data_alta = DATE_ADD(data_entrada, INTERVAL 3 DAY)
WHERE quarto_id IN (3, 4, 6);
SELECT * FROM internacao;

SELECT MAX(id) FROM convenio;
DELETE FROM consultas WHERE convenio_id = 4;
DELETE FROM convenio WHERE id = 4;
SELECT * FROM convenio;
SELECT * FROM consultas;
