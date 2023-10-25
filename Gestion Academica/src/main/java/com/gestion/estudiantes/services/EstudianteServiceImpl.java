package com.gestion.estudiantes.services;

import com.gestion.estudiantes.entity.Estudiante;
import com.gestion.estudiantes.dao.EstudianteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService{
    @Autowired
    EstudianteDAO estudianteDAO;

    //Put, saveEstudiante
    public Estudiante saveEstudiante(Estudiante estudiante){
        return estudianteDAO.save(estudiante);
    }

    //Post, modificarEstudiante
    public Estudiante modificarEstudiante(Estudiante estudiante, Long id){
        Optional<Estudiante> estudianteModificable = estudianteDAO.findById(id);
        if(estudianteModificable.isPresent()){
            Estudiante estudianteVieja = estudianteModificable.get();
            estudianteVieja.setNombre(estudiante.getNombre());
            estudianteVieja.setApellido(estudiante.getApellido());
            estudianteVieja.setDni(estudiante.getDni());
            estudianteVieja.setCurso(estudiante.getCurso());
            return estudianteDAO.save(estudianteVieja);
        }else{
            return null;
        }
    }

    //Delete, deleteEstudianteById
    public void deleteEstudianteById(Long id){
        estudianteDAO.deleteById(id);
    }

    //Get all, findEstudiantes
    public List<Estudiante> findEstudiantes(){
        return estudianteDAO.findAll();
    }

    //GetById, findEstudiantesById
    public Estudiante findEstudianteById(Long id){
        return estudianteDAO.findById(id).orElse(null);
    }


}
