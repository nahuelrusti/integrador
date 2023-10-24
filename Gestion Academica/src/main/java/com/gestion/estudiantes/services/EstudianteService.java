package com.gestion.estudiantes.services;

import com.gestion.estudiantes.model.EstudianteModel;
import com.gestion.estudiantes.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    //Put, saveEstudiante
    public EstudianteModel saveEstudiante(EstudianteModel estudianteModel){
        return estudianteRepository.save(estudianteModel);
    }

    //Post, modificarEstudiante
    public EstudianteModel modificarEstudiante(EstudianteModel estudiante, Long id){
        Optional<EstudianteModel> estudianteModificable = estudianteRepository.findById(id);
        if(estudianteModificable.isPresent()){
            EstudianteModel estudianteModelVieja = estudianteModificable.get();
            estudianteModelVieja.setNombre(estudiante.getNombre());
            estudianteModelVieja.setApellido(estudiante.getApellido());
            estudianteModelVieja.setDni(estudiante.getDni());
            estudianteModelVieja.setCurso(estudiante.getCurso());
            return estudianteRepository.save(estudianteModelVieja);
        }else{
            return null;
        }
    }

    //Delete, deleteEstudianteById
    public void deleteEstudianteById(Long id){
        estudianteRepository.deleteById(id);
    }

    //Get all, findEstudiantes
    public List<EstudianteModel> findEstudiantes(){
        return estudianteRepository.findAll();
    }

    //GetById, findEstudiantesById
    public EstudianteModel findEstudianteById(Long id){
        return estudianteRepository.findById(id).orElse(null);
    }


}
