CREATE DATABASE hospital_db_leandro_leao;
USE hospital_db_leandro_leao;
CREATE TABLE pacientes ( 
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200) NOT NULL,
cpf VARCHAR(11) NOT NULL,
data_nascimento DATE,
endereco VARCHAR(45) NOT NULL,
telefone VARCHAR(45) NOT NULL,
email VARCHAR(45) NOT NULL,
RG VARCHAR(45) NOT NULL
);
CREATE TABLE medicos (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200) NOT NULL,
data_nascimento DATE,
cpf VARCHAR(11) NOT NULL,
endereco VARCHAR(45) NOT NULL,
uf VARCHAR(2) NOT NULL,
crm VARCHAR(45) NOT NULL,
telefone VARCHAR(45) NOT NULL
);
CREATE TABLE especialidades (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45) NOT NULL
);
CREATE TABLE medicos_especialidades (
medico_id INT NOT NULL,
especialidade_id INT NOT NULL,
PRIMARY KEY (medico_id, especialidade_id),
CONSTRAINT FK_med FOREIGN KEY (medico_id) REFERENCES medicos(id),
CONSTRAINT FK_especialidade FOREIGN KEY (especialidade_id) REFERENCES especialidades(id)
);
CREATE TABLE convenio (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200) NOT NULL,
cnpj VARCHAR(45) NOT NULL,
tempo_carencia VARCHAR(45) NOT NULL
);
CREATE TABLE consultas (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
data_hora DATETIME NOT NULL,
valor DECIMAL(8,2),
paciente_id INT NOT NULL,
medico_id INT NOT NULL,
convenio_id INT NOT NULL,
CONSTRAINT FK_paciente FOREIGN KEY (paciente_id) REFERENCES pacientes(id),
CONSTRAINT FK_medico FOREIGN KEY (medico_id) REFERENCES medicos(id),
CONSTRAINT FK_convenio FOREIGN KEY (convenio_id) REFERENCES convenio(id)
);
CREATE TABLE tipo_quarto (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(45) NOT NULL,
valor_diaria VARCHAR(45) NOT NULL
);
CREATE TABLE quarto (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
numero INT,
tipo_quarto_id INT NOT NULL,
CONSTRAINT FK_tipo_quarto FOREIGN KEY (tipo_quarto_id) REFERENCES tipo_quarto(id)
);
CREATE TABLE internacao (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
data_entrada DATE,
data_prev_alta DATE,
data_alta DATE,
procedimento VARCHAR(45),
quarto_id INT NOT NULL,
CONSTRAINT FK_quarto FOREIGN KEY (quarto_id) REFERENCES quarto(id)
);
CREATE TABLE enfermeiro (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200) NOT NULL,
cpf VARCHAR(11) NOT NULL,
cre VARCHAR(45)
);
CREATE TABLE internacao_enfermeiro (
enfermeiro_id INT NOT NULL,
internacao_id INT NOT NULL,
PRIMARY KEY (enfermeiro_id, internacao_id),
CONSTRAINT FK_enfermeiro FOREIGN KEY (enfermeiro_id) REFERENCES enfermeiro(id),
CONSTRAINT FK_internacao FOREIGN KEY (internacao_id) REFERENCES internacao(id)
);
CREATE TABLE medicamentos (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200) NOT NULL,
dosagem VARCHAR(200),
fabricante VARCHAR(200)
);
CREATE TABLE receitas (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
consulta_id INT NOT NULL,
medicamento_id INT NOT NULL,
CONSTRAINT FK_consulta FOREIGN KEY (consulta_id) REFERENCES consultas(id),
CONSTRAINT FK_medicamento FOREIGN KEY (medicamento_id) REFERENCES medicamentos(id)
);
ALTER TABLE consultas
ADD COLUMN medicamento_id INT NULL,
ADD CONSTRAINT FK_medic FOREIGN KEY (medicamento_id) REFERENCES medicamentos(id);
ALTER TABLE internacao
ADD COLUMN paciente_id INT NOT NULL,
ADD CONSTRAINT FK_pacientes FOREIGN KEY (paciente_id) REFERENCES pacientes(id);

