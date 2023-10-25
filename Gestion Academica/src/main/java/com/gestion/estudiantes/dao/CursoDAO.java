package com.gestion.estudiantes.dao;

import com.gestion.estudiantes.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDAO extends JpaRepository<Curso, Long> {
}