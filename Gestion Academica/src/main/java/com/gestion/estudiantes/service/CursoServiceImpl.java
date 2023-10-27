package com.gestion.estudiantes.service;

import com.gestion.estudiantes.entity.Curso;
import com.gestion.estudiantes.dao.CursoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    CursoDAO cursoDAO;

    //Post, .saveCurso
    public Curso saveCurso(Curso curso){
        return cursoDAO.save(curso);
    }

    //Put, .modificarCurso
    public Curso modificarCurso(Curso curso, Long id){
        Optional<Curso> cursoModificable = cursoDAO.findById(id);
        if(cursoModificable.isPresent()){
            Curso cursoViejo = cursoModificable.get();
            cursoViejo.setNombre(curso.getNombre());
            //En caso que se cambie el instructor:
            cursoViejo.setInstructorFk(curso.getInstructorFk());
            return cursoDAO.save(cursoViejo);
        }else{
            return null;
        }
    }

    //DeleteById, .deleteCursoById
    public void deleteCursoById(Long id){
        cursoDAO.deleteById(id);
    }

    //Get, .findCursos
    public List<Curso> findCursos(){
        return cursoDAO.findAll();
    }

    //GetById, .findCursoById
    public Curso findCursoById(Long id){
        return cursoDAO.findById(id).orElse(null);
    }


}
