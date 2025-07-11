package com.alura.forohub.entity.cursos;

import com.alura.forohub.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {}