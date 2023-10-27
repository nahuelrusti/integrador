package com.gestion.estudiantes.servicesImpl;

import com.gestion.estudiantes.dto.EstudianteDTO;
import com.gestion.estudiantes.entity.Estudiante;
import com.gestion.estudiantes.dao.EstudianteDAO;
import com.gestion.estudiantes.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    @Autowired
    EstudianteDAO estudianteDAO;

    //Put, saveEstudiante
    @Override
    public Estudiante saveEstudiante(Estudiante estudiante){
        return estudianteDAO.save(estudiante);
    }

    //Post, modificarEstudiante
    @Override
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
    @Override
    public void deleteEstudianteById(Long id){
        estudianteDAO.deleteById(id);
    }

    //Get all, findEstudiantes
    @Override
    public List<EstudianteDTO> findEstudiantes(){
        return crearListDTO(estudianteDAO.findAll());
    }

    //GetById, findEstudianteById;
    @Override
    public EstudianteDTO findEstudianteById(Long id){
        Estudiante e = estudianteDAO.findById(id).orElse(null);
        if(e != null) {
            return crearDTO(e);
        }
        return null;
    }

    //Methods
    private List<EstudianteDTO> crearListDTO(List<Estudiante> estudiantes){
        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();
        for (Estudiante e:estudiantes) {
            estudiantesDTO.add(crearDTO(e));
        }
        return estudiantesDTO;
    }

    private EstudianteDTO crearDTO(Estudiante e){
        String nombreCompleto = e.getNombre().concat(" ").concat(e.getApellido());
        int edadActual = Period.between(e.getFechaNacimiento(), LocalDate.now()).getYears();
        return new EstudianteDTO(nombreCompleto, e.getDni(), e.getCurso(), edadActual);
    }

}
