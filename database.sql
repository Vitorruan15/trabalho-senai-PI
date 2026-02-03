-- Script para criar o banco de dados e tabela do Projeto Integrador
-- Execute este script no MySQL antes de rodar a aplicação

-- Criar banco de dados
CREATE DATABASE IF NOT EXISTS databasepi;

-- Usar o banco
USE databasepi;

-- Criar tabela de produtos
CREATE TABLE IF NOT EXISTS produtos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(500),
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL,
    categoria VARCHAR(50)
);

-- Inserir alguns dados de exemplo
INSERT INTO produtos (nome, descricao, preco, quantidade, categoria) VALUES
('Notebook Dell', 'Notebook Dell Inspiron 15 polegadas', 3500.00, 10, 'Eletrônicos'),
('Mouse Logitech', 'Mouse sem fio Logitech MX Master', 350.00, 25, 'Eletrônicos'),
('Camiseta Polo', 'Camiseta polo masculina tamanho M', 89.90, 50, 'Roupas'),
('Livro Java', 'Livro Java Como Programar 10a Edição', 180.00, 15, 'Livros'),
('Teclado Mecânico', 'Teclado mecânico RGB switches blue', 420.00, 8, 'Eletrônicos');

-- Verificar dados inseridos
SELECT * FROM produtos;
