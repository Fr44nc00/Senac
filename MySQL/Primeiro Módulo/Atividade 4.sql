USE hospital_db_leandro_leao;
DESCRIBE consultas;
-- Todos os dados e o valor médio das consultas do ano de 2020 realizadas SEM convênio
SELECT *FROM consultas 
WHERE YEAR(data_hora) = 2020 AND convenio_id IS NULL;

SELECT AVG(valor)
FROM consultas
WHERE YEAR(data_hora) = 2020 AND convenio_id IS NULL;


-- Todos os dados e o valor médio das consultas do ano de 2020 realizadas POR convênio
SELECT * FROM consultas
WHERE YEAR(data_hora) = 2020 AND convenio_id IS NOT NULL;

SELECT AVG(valor)
FROM consultas
WHERE YEAR(data_hora) = 2020 AND convenio_id IS NOT NULL;


-- Todos os dados das internações que tiveram data de alta maior que a data prevista para a alta
SELECT * FROM internacao
WHERE data_alta > data_prev_alta;


/* Receituário completo da primeira consulta registrada com receituário associado
essa tabela faz referencia as tabelas consulta aonde tem id do medicamento receitado, e o id do medicamento aonde contem nome, dosagem e fabricante*/
SELECT * FROM receitas
WHERE consulta_id = (SELECT MIN(id) FROM consultas);

SELECT * FROM consultas; -- Aqui estão as tabelas referenciadas na consulta acima
SELECT * FROM medicamentos; 


-- Todos os dados da consulta de maior valor e também da de menor valor (ambas as consultas não foram realizadas sob convênio)
SELECT *
FROM consultas
WHERE convenio_id IS NULL
ORDER BY valor DESC
LIMIT 1;

SELECT *
FROM consultas
WHERE convenio_id IS NULL
ORDER BY valor ASC
LIMIT 1;


-- Todos os dados das internações em seus respectivos quartos, calculando o total da internação a partir do valor de diária do quarto e o número de dias entre a entrada e a alta
SELECT internacao.*, tipo_quarto.valor_diaria * DATEDIFF(internacao.data_alta, internacao.data_entrada) AS total_internacao
FROM internacao
JOIN quarto ON internacao.quarto_id = quarto.id
JOIN tipo_quarto ON quarto.tipo_quarto_id = tipo_quarto.id;


-- Data, procedimento e número de quarto de internações em quartos do tipo "apartamento"
SELECT internacao.data_entrada, internacao.procedimento, quarto.numero
FROM internacao
JOIN quarto ON internacao.quarto_id = quarto.id
JOIN tipo_quarto ON quarto.tipo_quarto_id = tipo_quarto.id
WHERE tipo_quarto.descricao = 'apartamentos';


-- Nome do paciente, data da consulta e especialidade de todas as consultas em que os pacientes eram menores de 18 anos na data da consulta e cuja especialidade não seja "pediatria", ordenando por data de realização da consulta
SELECT pacientes.nome, consultas.data_hora, especialidades.nome
FROM consultas
JOIN pacientes ON consultas.paciente_id = pacientes.id
JOIN medicos ON consultas.medico_id = medicos.id
JOIN medicos_especialidades ON medicos.id = medicos_especialidades.medico_id
JOIN especialidades ON medicos_especialidades.especialidade_id = especialidades.id
WHERE pacientes.data_nascimento > DATE_SUB(consultas.data_hora, INTERVAL 18 YEAR)
AND especialidades.nome != "pediatria"
ORDER BY consultas.data_hora;


-- Nome do paciente, nome do médico, data da internação e procedimentos das internações realizadas por médicos da especialidade "gastroenterologia", que tenham acontecido em "enfermaria"
SELECT pacientes.nome, medicos.nome, internacao.data_entrada, internacao.procedimento
FROM internacao
JOIN pacientes ON internacao.paciente_id = pacientes.id
JOIN medicos ON internacao.medico_id = medicos.id
JOIN quarto ON internacao.quarto_id = quarto.id
JOIN tipo_quarto ON quarto.tipo_quarto_id = tipo_quarto.id
JOIN medicos_especialidades ON medicos.id = medicos_especialidades.medico_id
JOIN especialidades ON medicos_especialidades.especialidade_id = especialidades.id
WHERE especialidades.nome = "Gastroenterologia" AND tipo_quarto.descricao = "enfermaria";


-- Os nomes dos médicos, seus CRMs e a quantidade de consultas que cada um realizou
SELECT medicos.nome, medicos.crm, COUNT(consultas.id) AS quantidade_consultas
FROM medicos
JOIN consultas ON medicos.id = consultas.medico_id
GROUP BY medicos.nome, medicos.crm;


-- Os nomes, CREs e número de internações de enfermeiros que participaram de mais de uma internação
SELECT enfermeiro.nome, enfermeiro.cre, COUNT(internacao_enfermeiro.enfermeiro_id) AS numero_internacoes
FROM enfermeiro
JOIN internacao_enfermeiro ON enfermeiro.id = internacao_enfermeiro.enfermeiro_id
GROUP BY enfermeiro.nome, enfermeiro.cre
HAVING COUNT(internacao_enfermeiro.enfermeiro_id) > 1;


-- Consulta extra
/*
Essa consulta retorna o nome do paciente, data da consulta, nome do médico e valor da consulta para todas as consultas realizadas por médicos de uma determinada especialidade,
ordenadas pelo valor da consulta em ordem decrescente.
*/
SELECT pacientes.nome, consultas.data_hora, medicos.nome
FROM consultas
JOIN pacientes ON consultas.paciente_id = pacientes.id
JOIN medicos ON consultas.medico_id = medicos.id
JOIN medicos_especialidades ON medicos.id = medicos_especialidades.medico_id
JOIN especialidades ON medicos_especialidades.especialidade_id = especialidades.id
WHERE especialidades.nome = "Pediatria" -- Aqui você pode substituir com o nome de outras especialidades 
ORDER BY consultas.data_hora DESC;



