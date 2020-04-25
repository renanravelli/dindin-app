CREATE SCHEMA IF NOT EXISTS ${schema};

CREATE TABLE ${schema}.TB_INFORMACAO
(
    ID              SERIAL,
    NOME            VARCHAR(50) NOT NULL,
    DOCUMENTO       VARCHAR(16),
    DATA_NASCIMENTO DATE,
    TELEFONE        VARCHAR(14),
    EMAIL           VARCHAR(50) NOT NULL UNIQUE,
    ID_ENDERECO     BIGINT,
    PRIMARY KEY (ID),
    FOREIGN KEY (ID_ENDERECO) REFERENCES ${schema}.TB_ENDERECO
);

INSERT INTO ${schema}.tb_informacao (nome, documento, data_nascimento, telefone, email, id_endereco)
VALUES ('Administrador', '00000000000', '2020-04-12', '61 0 00000000', 'administrador@dindin.com', 1);
