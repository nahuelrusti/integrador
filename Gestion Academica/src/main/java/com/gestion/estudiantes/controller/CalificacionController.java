package com.gestion.estudiantes.controller;

import com.gestion.estudiantes.dto.CalificacionDTO;
import com.gestion.estudiantes.entity.Calificacion;
import com.gestion.estudiantes.entity.Contacto;
import com.gestion.estudiantes.servicesImpl.CalificacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class CalificacionController {
    @Autowired
    private CalificacionServiceImpl calificacionService;

    @PostMapping("/calificaciones/nuevo")
    public Calificacion nuevoContacto(@RequestBody Calificacion calificacionNuevo){
        return calificacionService.saveCalificacion(calificacionNuevo);
    }

    @PutMapping("/calificaciones/{id}")
    public Calificacion editarcalificacion(@RequestBody Calificacion calificacion, @PathVariable Long id){
        return calificacionService.modificarCalificacion(calificacion, id);
    }

    @DeleteMapping("/calificaciones/{id}")
    public void eliminarcalificacion(@PathVariable Long id) {
        calificacionService.deleteCalificacionById(id);
    }

    @GetMapping("/calificaciones/{id}")
    private CalificacionDTO getCalificacion(@PathVariable Long id){
        return calificacionService.findCalificacionById(id);
    }

    @GetMapping("/calificaciones")
    private List<CalificacionDTO> getCalificacionList(){
        return calificacionService.findCalificacion();
    }

}
