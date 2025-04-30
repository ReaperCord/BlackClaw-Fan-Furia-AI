CREATE TABLE jogadores (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    nickname VARCHAR(100),
    idade INT,
    nacionalidade VARCHAR(100),
    funcao_ingame VARCHAR(50),
    tipo_contrato VARCHAR(50),
    data_de_entrada DATE,
    data_de_saida DATE,
    duracao_contrato VARCHAR(50)
);
