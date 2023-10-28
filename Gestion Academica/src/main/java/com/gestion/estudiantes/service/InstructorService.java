package com.gestion.estudiantes.service;

import com.gestion.estudiantes.dto.InstructorDTO;
import com.gestion.estudiantes.entity.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor saveInstructor(Instructor i);
    Instructor modificarInstructor(Instructor i, Long id);
    void deleteInstructorById(Long id);
    List<InstructorDTO> findInstructor();
    InstructorDTO findInstructorById(Long id);

}
