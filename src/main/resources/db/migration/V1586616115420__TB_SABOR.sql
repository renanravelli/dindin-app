CREATE SCHEMA IF NOT EXISTS ${schema};

CREATE TABLE IF NOT EXISTS ${schema}.TB_SABOR
(
    ID        SERIAL,
    NOME      VARCHAR(50) NOT NULL,
    DESCRICAO VARCHAR(255),
    PRIMARY KEY (ID)
);

INSERT INTO ${schema}.tb_sabor (nome) VALUES ('Morango');
INSERT INTO ${schema}.tb_sabor (nome) VALUES ('Maracujá');
INSERT INTO ${schema}.tb_sabor (nome) VALUES ('Chocolate');
INSERT INTO ${schema}.tb_sabor (nome) VALUES ('Creme');
INSERT INTO ${schema}.tb_sabor (nome) VALUES ('Uva');
INSERT INTO ${schema}.tb_sabor (nome) VALUES ('Nutella');
INSERT INTO ${schema}.tb_sabor (nome) VALUES ('Açai');
