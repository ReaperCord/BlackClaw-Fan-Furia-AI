CREATE TABLE mapas (
    id SERIAL PRIMARY KEY,
    partidas_id INT REFERENCES partidas(id) ON DELETE CASCADE,
    nome_mapa VARCHAR(50)
);
