package com.login.controller;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.tipoEvento.TipoEventoRequestCompleteDto;
import com.login.dto.tipoEvento.TipoEventoRequestDto;
import com.login.service.imple.tipoEvento.TipoEventoServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/tipo-evento")
public class TipoEventoController {

    @Autowired
    private final TipoEventoServiceImplement tipoEventoServiceImplement;

    private ResponseDefaultDto responseDefaultDto;

    public TipoEventoController(TipoEventoServiceImplement tipoEventoServiceImplement) {
        this.tipoEventoServiceImplement = tipoEventoServiceImplement;
    }

    @PostMapping(value = "/create")
    public ResponseDefaultDto add(@RequestBody TipoEventoRequestDto tipoEventoRequestDto){
        return tipoEventoServiceImplement.save(tipoEventoRequestDto);
    }

    @GetMapping("/getAll")
    public ResponseDefaultDto getAll(){
        return tipoEventoServiceImplement.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseDefaultDto getById(@PathVariable("id") Long id){
        return tipoEventoServiceImplement.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDefaultDto delete(@PathVariable("id") Long id){
        return tipoEventoServiceImplement.delete(id);
    }

    @PutMapping(value = "/update")
    public ResponseDefaultDto update(@RequestBody TipoEventoRequestCompleteDto tipoEventoRequestDto){
        return tipoEventoServiceImplement.update(tipoEventoRequestDto);
    }
}
