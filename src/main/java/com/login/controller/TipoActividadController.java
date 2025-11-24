package com.login.controller;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.tipoActividad.TipoActividadRequestCompleteDto;
import com.login.dto.tipoActividad.TipoActividadRequestDto;
import com.login.dto.tipoEvento.TipoEventoRequestCompleteDto;
import com.login.service.imple.tipoActividad.TipoActividadServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/tipo-actividad")
public class TipoActividadController {

    @Autowired
    private TipoActividadServiceImplement tipoActividadServiceImplement;

    private ResponseDefaultDto responseDefaultDto;

    @PostMapping(value = "/create")
    public ResponseDefaultDto add(TipoActividadRequestDto tipoActividadRequestDto){
        return tipoActividadServiceImplement.save(tipoActividadRequestDto);
    }

    @GetMapping("/getAll")
    public ResponseDefaultDto getAll(){
        return tipoActividadServiceImplement.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseDefaultDto getById(@PathVariable("id") Long id){
        return tipoActividadServiceImplement.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDefaultDto delete(@PathVariable("id") Long id){
        return tipoActividadServiceImplement.delete(id);
    }

    @PutMapping(value = "/update")
    public ResponseDefaultDto update(TipoActividadRequestCompleteDto tipoActividadRequestDto){
        return tipoActividadServiceImplement.update(tipoActividadRequestDto);
    }
}
