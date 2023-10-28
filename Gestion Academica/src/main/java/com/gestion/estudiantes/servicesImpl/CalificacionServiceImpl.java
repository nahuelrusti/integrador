package com.gestion.estudiantes.servicesImpl;

import com.gestion.estudiantes.dao.CalificacionDAO;
import com.gestion.estudiantes.dto.CalificacionDTO;
import com.gestion.estudiantes.entity.Calificacion;
import com.gestion.estudiantes.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CalificacionServiceImpl implements CalificacionService {

    @Autowired
    CalificacionDAO calificacionDAO;

    @Override
    public Calificacion saveCalificacion(Calificacion c) {
        return calificacionDAO.save(c);
    }

    @Override
    public Calificacion modificarCalificacion(Calificacion c, Long id) {
        Optional<Calificacion> calificacionModificable = calificacionDAO.findById(id);
        if(calificacionModificable.isPresent()){
            Calificacion contactoViejo = calificacionModificable.get();
            contactoViejo.setNota(c.getNota());
            contactoViejo.setEstudianteFk(c.getEstudianteFk());
            contactoViejo.setInstructorFk(c.getInstructorFk());
            return calificacionDAO.save(contactoViejo);
        }else{
            return null;
        }
    }

    @Override
    public void deleteCalificacionById(Long id) {
        calificacionDAO.deleteById(id);
    }

    @Override
    public List<CalificacionDTO> findCalificacion() {
        return crearListDTO(calificacionDAO.findAll());
    }

    @Override
    public CalificacionDTO findCalificacionById(Long id) {
        Calificacion calificacion = calificacionDAO.findById(id).orElse(null);
        if(calificacion != null) {
            return crearDTO(calificacion);
        }
        return null;
    }

    private List<CalificacionDTO> crearListDTO(List<Calificacion> calificaciones){
        List<CalificacionDTO> calificacionDTO = new ArrayList<>();
        for (Calificacion e:calificaciones) {
            calificacionDTO.add(crearDTO(e));
        }
        return calificacionDTO;
    }

    private CalificacionDTO crearDTO(Calificacion c){
        return new CalificacionDTO(c.getEstudianteFk(), c.getInstructorFk(), c.getNota());
    }
}
