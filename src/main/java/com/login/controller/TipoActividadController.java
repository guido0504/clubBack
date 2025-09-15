package com.login.controller;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.tipoActividad.TipoActividadRequestDto;
import com.login.service.imple.tipoActividad.TipoActividadServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tipo-actividad")
public class TipoActividadController {

    @Autowired
    private TipoActividadServiceImplement tipoActividadServiceImplement;

    private ResponseDefaultDto responseDefaultDto;

    @PostMapping(value = "/create")
    public ResponseDefaultDto add(TipoActividadRequestDto tipoActividadRequestDto){
        tipoActividadServiceImplement.save(tipoActividadRequestDto);
        responseDefaultDto = new ResponseDefaultDto(200,"Exitoso",tipoActividadRequestDto,"Se agrego el tipo de actividad");
        return responseDefaultDto;
    }

    @GetMapping("/getAll")
    public ResponseDefaultDto getAll(){
        responseDefaultDto = new ResponseDefaultDto(200,"Exitoso",tipoActividadServiceImplement.findAll(),"Se muestran los tipos de actividades");
        return responseDefaultDto;
    }

    @GetMapping("/getById/{id}")
    public ResponseDefaultDto getById(@PathVariable("id") Long id){
        responseDefaultDto = new ResponseDefaultDto(200,"Exitoso",tipoActividadServiceImplement.findById(id),"Se muestran los tipos de actividades");
        return responseDefaultDto;
    }
}
