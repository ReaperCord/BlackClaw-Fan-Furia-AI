CREATE TABLE partidas (
    id SERIAL PRIMARY KEY,
    evento_id INT NOT NULL,
    adversario VARCHAR(100),
    data DATE,
    tempo_geral_partida TIME,
    CONSTRAINT fk_evento
        FOREIGN KEY (evento_id)
        REFERENCES eventos(id)
        ON DELETE CASCADE
);