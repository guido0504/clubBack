package com.login.controller;

import com.login.dto.pais.PaisResponseDto;
import com.login.entity.pais.Pais;
import com.login.service.imple.pais.PaisServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pais")
public class PaisController {

    @Autowired
    PaisServiceImplement paisServiceImplement;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public ResponseEntity<List<Pais>> findAll(){
        return ResponseEntity.ok(paisServiceImplement.findAll());
    }
}
