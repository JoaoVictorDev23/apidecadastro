
-- Versão da Migração: 1
CREATE TABLE usuarios (
          id VARCHAR(255) PRIMARY KEY,
          name VARCHAR(255) NOT NULL,
          email VARCHAR(255) NOT NULL UNIQUE,
          senha VARCHAR(255) NOT NULL
);

-- Adiciona a tabela para armazenar os perfis
CREATE TABLE usuario_perfis (
          usuario_id VARCHAR(255) REFERENCES usuarios(id),
          perfil INT NOT NULL,
          PRIMARY KEY (usuario_id, perfil)
);