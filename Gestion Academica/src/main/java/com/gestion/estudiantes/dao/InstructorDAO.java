package com.gestion.estudiantes.dao;

import com.gestion.estudiantes.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDAO extends JpaRepository<Instructor, Long> {
}
