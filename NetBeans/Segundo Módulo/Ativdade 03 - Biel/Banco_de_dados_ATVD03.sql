-- usei as mesmas coisas do 2 sóo mudei numero_epsodio de inteiro pra varchar --

CREATE TABLE podcasts (
    id INT(11) NOT NULL AUTO_INCREMENT,
    produtor VARCHAR(100) NOT NULL,
    nome_episodio VARCHAR(100) NOT NULL,
    numero_episodio VARCHAR(50) NOT NULL,
    duracao VARCHAR(50) NOT NULL,
    url VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
