-- Script SQL - Sistema de Academia
-- Entidade: Plano
-- Trabalho M3 - API REST com Quarkus

DROP TABLE IF EXISTS plano;

CREATE TABLE plano(

    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    duracao INTEGER NOT NULL
);

INSERT INTO plano (nome, descricao, valor, duracao) VALUES
    ('Mensal', 'Acesso completo à academia por 1 mês', 55.10, 1);

INSERT INTO plano (nome, descricao, valor, duracao) VALUES
    ('Bi-Mensal', 'Acesso completo à academia por 2 mês', 110.10, 2);

INSERT INTO plano (nome, descricao, valor, duracao) VALUES
    ('Trimestral', 'Acesso completo à academia por 3 mês', 165.10, 3);

INSERT INTO plano (nome, descricao, valor, duracao) VALUES
    ('Plano Estação', 'Acesso completo à academia por 4 mês', 220.10, 4);


-- gb