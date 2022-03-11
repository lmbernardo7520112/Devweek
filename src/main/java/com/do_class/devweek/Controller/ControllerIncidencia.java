package com.do_class.devweek.Controller;

import com.do_class.devweek.Entity.Incidencia;
import com.do_class.devweek.Repository.IncidenciaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class ControllerIncidencia {

    private final IncidenciaRepo iRepository;


    public ControllerIncidencia(IncidenciaRepo iRepository) {
        this.iRepository = iRepository;
    }

    @GetMapping("/incidencias")
    public ResponseEntity<List<Incidencia>> findIncidencia(){
        List<Incidencia> listaIncidencia = iRepository.findAll();
        if (listaIncidencia.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return new ResponseEntity<>(listaIncidencia, HttpStatus.OK);
    }

    @GetMapping("/ocorrencia/{id}")
    public ResponseEntity<Incidencia> findIncidenciaById(@PathVariable Long id){
        Optional<Incidencia> incidenciaOptional = iRepository.findById(id);
        if (incidenciaOptional.isPresent()){
            Incidencia incidenciaUnid = (Incidencia) incidenciaOptional.get();
            return new ResponseEntity<>(incidenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
