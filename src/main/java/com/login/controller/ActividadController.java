package com.login.controller;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.actividad.AddActividadRequestDTO;
import com.login.dto.actividad.UpdateActividadRequestDTO;
import com.login.service.imple.actividad.ActividadServiceImplement;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/actividad")
public class ActividadController {

    @Autowired
    private ActividadServiceImplement actividadServiceImplement;

    @PostMapping(value = "/create")
    public ResponseDefaultDto create(AddActividadRequestDTO addActividadRequestDTO) throws PSQLException {
        return actividadServiceImplement.create(addActividadRequestDTO);
    }

    @GetMapping(value = "/findAll")
    public ResponseDefaultDto findAll(){
        return actividadServiceImplement.findAll();
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseDefaultDto findById(@PathVariable("id") long id){
        return actividadServiceImplement.findById(id);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDefaultDto update(@PathVariable("id") long id, UpdateActividadRequestDTO updateActividadRequestDTO){
        return actividadServiceImplement.update(id,updateActividadRequestDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDefaultDto delete(@PathVariable("id") long id){
        return actividadServiceImplement.delete(id);
    }
}
