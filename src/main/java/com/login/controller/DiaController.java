package com.login.controller;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.dia.AddDiaRequestDTO;
import com.login.dto.dia.UpdateDiaRequestDTO;
import com.login.service.imple.dia.DiaServiceImplement;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/dia")
public class DiaController {

    @Autowired
    private DiaServiceImplement diaServiceImplement;

    @PostMapping(value = "/create")
    public ResponseDefaultDto create(AddDiaRequestDTO addDiaRequestDto) throws PSQLException {
        return diaServiceImplement.create(addDiaRequestDto);
    }

    @GetMapping(value = "/findAll")
    public ResponseDefaultDto findAll(){
        return diaServiceImplement.findAll();
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseDefaultDto findById(@PathVariable("id") long id){
        return diaServiceImplement.findById(id);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDefaultDto update(@PathVariable("id") long id, UpdateDiaRequestDTO updateDiaRequestDTO){
        return diaServiceImplement.update(id,updateDiaRequestDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDefaultDto delete(@PathVariable("id") long id){
        return diaServiceImplement.delete(id);
    }
}
