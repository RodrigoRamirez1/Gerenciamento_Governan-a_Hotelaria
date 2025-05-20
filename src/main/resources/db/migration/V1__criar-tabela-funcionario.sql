CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE funcionario (
        id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
        nome VARCHAR(100) NOT NULL,
        idade INTEGER NOT NULL,
        cpf BIGINT NOT NULL,
        cargo VARCHAR(100) NOT NULL,
        telefone BIGINT NOT NULL
);