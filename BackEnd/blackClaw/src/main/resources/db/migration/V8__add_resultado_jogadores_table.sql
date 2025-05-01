CREATE TABLE resultado_jogadores (
    resultado_id BIGINT NOT NULL,
    jogador_id BIGINT NOT NULL,
    PRIMARY KEY (resultado_id, jogador_id),
    FOREIGN KEY (resultado_id) REFERENCES resultados(id),
    FOREIGN KEY (jogador_id) REFERENCES jogadores(id)
);

-- Remover coluna antiga
ALTER TABLE resultados DROP CONSTRAINT CONSTRAINT_FAD9;