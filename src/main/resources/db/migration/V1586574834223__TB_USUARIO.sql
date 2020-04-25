CREATE SCHEMA IF NOT EXISTS ${schema};

CREATE TABLE ${schema}.TB_USUARIO
(
    ID            SERIAL,
    USUARIO       VARCHAR(20)  NOT NULL,
    SENHA         VARCHAR(100) NOT NULL,
    PERFIL        VARCHAR(20)  NOT NULL,
    FOTO          BYTEA,
    ID_INFORMACAO BIGINT       NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (ID_INFORMACAO) REFERENCES ${schema}.TB_INFORMACAO (ID)
);

INSERT INTO ${schema}.tb_usuario (usuario, senha, perfil, id_informacao)
VALUES ('administrador', '$2a$10$3crgVUUzju7rn43D/a93E.2jf6dWO7xkZ3src87RuX9J9GzVD9xKO', 'ADMINISTRADOR', 1);
