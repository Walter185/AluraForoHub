package com.alura.forohub.curso.repository;

import com.alura.forohub.curso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {}