package com.login.controller;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.tipoActividad.TipoActividadRequestDto;
import com.login.service.imple.tipoActividad.TipoActividadServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tipo-actividad")
public class TipoActividadController {

    @Autowired
    private TipoActividadServiceImplement tipoActividadServiceImplement;

    private ResponseDefaultDto responseDefaultDto;

    @PostMapping(value = "/add")
    public ResponseDefaultDto add(TipoActividadRequestDto tipoActividadRequestDto){
        tipoActividadServiceImplement.save(tipoActividadRequestDto);
        responseDefaultDto = new ResponseDefaultDto(200,"Exitoso",tipoActividadRequestDto,"Se agrego el tipo de actividad");
        return responseDefaultDto;
    }
}
