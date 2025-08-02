package com.login.service;

import com.login.entity.pais.Pais;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PaisService {

    public Pais save(Pais pais);

    public List<Pais> findAll();

    public Optional<Pais> findById(Long id);

    public Pais update(Pais pais);

    public String delete(Long id);
}
