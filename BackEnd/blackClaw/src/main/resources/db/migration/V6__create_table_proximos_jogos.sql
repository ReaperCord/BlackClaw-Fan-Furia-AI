CREATE TABLE proximos_jogos (
    id SERIAL PRIMARY KEY,
    evento_id INT REFERENCES eventos(id) ON DELETE SET NULL,
    adversario VARCHAR(100),
    data DATE
);