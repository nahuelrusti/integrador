package com.gestion.estudiantes.services;

import com.gestion.estudiantes.model.CursoModel;
import com.gestion.estudiantes.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    //Post, .saveCurso
    public CursoModel saveCurso(CursoModel cursoModel){
        return cursoRepository.save(cursoModel);
    }

    //Put, .modificarCurso
    public CursoModel modificarCurso(CursoModel curso, Long id){
        Optional<CursoModel> cursoModificable = cursoRepository.findById(id);
        if(cursoModificable.isPresent()){
            CursoModel cursoViejo = cursoModificable.get();
            cursoViejo.setNombre(curso.getNombre());
            //En caso que se cambie el instructor:
            cursoViejo.setInstructorFk(curso.getInstructorFk());
            return cursoRepository.save(cursoViejo);
        }else{
            return null;
        }
    }

    //DeleteById, .deleteCursoById
    public void deleteCursoById(Long id){
        cursoRepository.deleteById(id);
    }

    //Get, .findCursos
    public List<CursoModel> findCursos(){
        return cursoRepository.findAll();
    }

    //GetById, .findCursoById
    public CursoModel findCursoById(Long id){
        return cursoRepository.findById(id).orElse(null);
    }


}
