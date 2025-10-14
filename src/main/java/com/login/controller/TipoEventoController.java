package com.login.controller;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.tipoActividad.TipoActividadRequestDto;
import com.login.dto.tipoEvento.TipoEventoRequestCompleteDto;
import com.login.dto.tipoEvento.TipoEventoRequestDto;
import com.login.entity.tipoEvento.TipoEvento;
import com.login.service.imple.tipoEvento.TipoEventoServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/tipo-evento")
public class TipoEventoController {

    @Autowired
    private TipoEventoServiceImplement tipoEventoServiceImplement;

    private ResponseDefaultDto responseDefaultDto;

    public TipoEventoController(TipoEventoServiceImplement tipoEventoServiceImplement) {
        this.tipoEventoServiceImplement = tipoEventoServiceImplement;
    }

    @PostMapping(value = "/create")
    public ResponseDefaultDto add(TipoEventoRequestDto tipoEventoRequestDto){
        tipoEventoServiceImplement.save(tipoEventoRequestDto);
        return new ResponseDefaultDto(200,"Exitoso",tipoEventoRequestDto,"Se agrego el tipo de evento");
    }

    @GetMapping("/getAll")
    public ResponseDefaultDto getAll(){
        responseDefaultDto = new ResponseDefaultDto(200,"Exitoso",tipoEventoServiceImplement.getAll(),"Se muestran los tipos de actividades");
        return responseDefaultDto;
    }

    @GetMapping("/getById/{id}")
    public ResponseDefaultDto getById(@PathVariable("id") Long id){
        responseDefaultDto = new ResponseDefaultDto(200,"Exitoso",tipoEventoServiceImplement.getById(id),"Se muestran los tipos de eventos");
        return responseDefaultDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDefaultDto delete(@PathVariable("id") Long id){
        responseDefaultDto = new ResponseDefaultDto(200,"Exitoso",null,tipoEventoServiceImplement.delete(id));
        return responseDefaultDto;
    }

    @PutMapping(value = "/update")
    public ResponseDefaultDto update(TipoEventoRequestCompleteDto tipoEventoRequestDto){
        tipoEventoServiceImplement.update(tipoEventoRequestDto);
        return new ResponseDefaultDto(200,"Exitoso",tipoEventoRequestDto,"Se modifico el tipo de evento");
    }
}
