package com.gestion.estudiantes.servicesImpl;

import com.gestion.estudiantes.dto.CursoDTO;
import com.gestion.estudiantes.entity.Curso;
import com.gestion.estudiantes.dao.CursoDAO;
import com.gestion.estudiantes.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    CursoDAO cursoDAO;

    //Post, .saveCurso
    @Override
    public Curso saveCurso(Curso curso){
        return cursoDAO.save(curso);
    }

    //Put, .modificarCurso
    @Override
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
    @Override
    public void deleteCursoById(Long id){
        cursoDAO.deleteById(id);
    }

    //Get, .findCursos
    @Override
    public List<CursoDTO> findCursos(){
        return crearListDTO(cursoDAO.findAll());
    }

    //GetById, .findCursoById
    @Override
    public CursoDTO findCursoById(Long id){
        Curso curso = cursoDAO.findById(id).orElse(null);
        if(curso != null) {
            return crearDTO(curso);
        }
        return null;
    }

    private List<CursoDTO> crearListDTO(List<Curso> cursos){
        List<CursoDTO> cursoDTO = new ArrayList<>();
        for (Curso e:cursos) {
            cursoDTO.add(crearDTO(e));
        }
        return cursoDTO;
    }

    private CursoDTO crearDTO(Curso c){
        return new CursoDTO(c.getNombre(), c.getInstructorFk());
    }

}
