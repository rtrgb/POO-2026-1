-- ============================================================
-- Script SQL - Sistema de Academia
-- Entidade: Plano
-- ============================================================

-- Criar o banco de dados (execute este comando separado no psql)
-- CREATE DATABASE academia;

-- Conectar ao banco academia antes de executar o restante
-- \c academia

-- Criar schema
CREATE SCHEMA IF NOT EXISTS public;

-- ============================================================
-- TABELA: plano
-- ============================================================

DROP TABLE IF EXISTS plano;

CREATE TABLE plano (
    id        SERIAL PRIMARY KEY,
    nome      VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    valor     NUMERIC(10, 2) NOT NULL,
    duracao   INTEGER NOT NULL  -- duracao em meses
);

-- ============================================================
-- Registros de teste
-- ============================================================

INSERT INTO plano (nome, descricao, valor, duracao) VALUES
    ('Plano Mensal',    'Acesso completo a academia por 1 mes.',         159.99, 1),
    ('Plano Trimestral','Acesso completo a academia por 3 meses.',       399.99, 3),
    ('Plano Semestral', 'Acesso completo a academia por 6 meses.',       699.99, 6),
    ('Plano Anual',     'Acesso completo a academia por 12 meses.',     1199.99, 12);

-- ============================================================
-- Verificar os dados inseridos
-- ============================================================
SELECT * FROM plano;
