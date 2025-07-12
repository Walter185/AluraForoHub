-- Inserta cursos
INSERT INTO cursos (id, nombre, categoria)
VALUES (1, 'Spring Boot', 'Programación'),
       (2, 'React', 'Frontend');

-- Inserta usuarios (con nombre incluido)
INSERT INTO usuarios (id, nombre, username, password, role)
VALUES
  (1, 'Juan Pérez', 'juan123', '123456', 'USER'),
  (2, 'Ana Gómez', 'ana456', '123456', 'USER');


-- Inserta tópicos
INSERT INTO topicos (titulo, mensaje, fecha_de_creacion, status, autor_id, curso_id)
VALUES
  ('Primer Tópico', 'Mensaje sobre Spring Boot', NOW(), 'NO_RESPONDIDO', 1, 1),
  ('Segundo Tópico', 'Duda con React', NOW(), 'NO_RESPONDIDO', 2, 2);
