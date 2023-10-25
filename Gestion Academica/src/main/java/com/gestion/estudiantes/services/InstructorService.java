package com.gestion.estudiantes.services;

import com.gestion.estudiantes.entity.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor saveInstructor(Instructor i);
    Instructor modificarInstructor(Instructor i, Long id);
    void deleteInstructorById(Long id);
    List<Instructor> findInstructor();
    Instructor findInstructorById(Long id);

}
