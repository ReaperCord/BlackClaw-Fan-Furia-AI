CREATE TABLE resultados (
    id SERIAL PRIMARY KEY,
    mapa_id INT REFERENCES mapas(id) ON DELETE CASCADE,
    jogador_id INT REFERENCES jogadores(id) ON DELETE CASCADE,
    abates INT,
    mortes INT,
    diferenca INT,
    adr DECIMAL(5,2),
    kast DECIMAL(5,2),
    rating DECIMAL(4,2),
    UNIQUE (mapa_id, jogador_id)
);