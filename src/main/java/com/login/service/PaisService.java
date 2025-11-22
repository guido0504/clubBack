package com.login.service;

import com.login.entity.pais.Pais;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PaisService {

    Pais save(Pais pais);

    List<Pais> findAll();

    Optional<Pais> findById(Long id);

    Pais update(Pais pais);

    String delete(Long id);
}
