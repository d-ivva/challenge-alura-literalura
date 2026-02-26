CREATE TABLE autores (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) UNIQUE NOT NULL,
    ano_nascimento INTEGER,
    ano_falecimento INTEGER
);

CREATE TABLE livros (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(255) UNIQUE NOT NULL,
    idioma VARCHAR(10),
    numero_downloads DOUBLE PRECISION,
    autor_id BIGINT NOT NULL,
    CONSTRAINT fk_livros_autor FOREIGN KEY (autor_id) REFERENCES autores(id)
);