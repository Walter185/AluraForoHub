-- Cursos base
INSERT INTO cursos (nombre, categoria) VALUES
('Spring Boot', 'Backend'),
('React JS', 'Frontend');

-- Tópicos de ejemplo
INSERT INTO topicos (titulo, mensaje, fecha_de_creacion, status, autor, curso_id) VALUES
('¿Cómo resolver error 500?', 'Tengo un error 500 al hacer login. ¿Alguna idea?', NOW(), 'NO_RESPONDIDO', 'walter', 1),
('Mejoras en el rendimiento', '¿Qué técnicas usan para mejorar rendimiento en Spring Boot?', NOW(), 'RESPONDIDO', 'lucia', 1),
('Error al conectar con MySQL', 'No se conecta con la base de datos, dice timeout', NOW(), 'NO_RESPONDIDO', 'juan', 1),
('Validaciones en DTOs', '¿Cómo validar campos nulos en un DTO con anotaciones?', NOW(), 'CERRADO', 'ana', 2);
