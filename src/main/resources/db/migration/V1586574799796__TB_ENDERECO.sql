CREATE SCHEMA IF NOT EXISTS ${schema};

CREATE TABLE IF NOT EXISTS ${schema}.tb_endereco
(
    ID          SERIAL,
    ESTADO      VARCHAR(100),
    CIDADE      VARCHAR(100),
    BAIRRO      VARCHAR(100),
    ENDERECO    VARCHAR(200),
    CEP         VARCHAR(11),
    NRO         VARCHAR(30),
    COMPLEMENTO VARCHAR(50),
    PRIMARY KEY (ID)
);

INSERT INTO ${schema}.tb_endereco (estado, cidade, bairro, endereco, cep, nro, complemento)
VALUES ('DF', 'Brasilia', 'Sobradinho', '-', '00000000', 'CS 01', '-');
