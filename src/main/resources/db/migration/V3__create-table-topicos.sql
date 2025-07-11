CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(255) NOT NULL,
    fecha_de_creacion DATETIME NOT NULL,
    status VARCHAR(20) NOT NULL,
    autor VARCHAR(50) NOT NULL,
    curso_id BIGINT NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_topico_curso_id FOREIGN KEY (curso_id) REFERENCES cursos(id)
);
