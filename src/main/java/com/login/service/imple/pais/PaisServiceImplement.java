package com.login.service.imple.pais;

import com.login.entity.pais.Pais;
import com.login.repository.PaisRepository.PaisRepository;
import com.login.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImplement implements PaisService {

    @Autowired
    private PaisRepository paisRepository;


    @Override
    public Pais save(Pais pais) {
        Pais p = paisRepository.save(pais);
        return p ;
    }

    @Override
    public List<Pais> findAll() {
        List<Pais> list = paisRepository.findAll();
        return list;
    }


    @Override
    public Optional<Pais> findById(Long id) {
        Optional<Pais> pais = paisRepository.findById(id);
        return pais;
    }

    @Override
    public Pais update(Pais pais) {
        Pais p = paisRepository.save(pais);
        return p;
    }

    @Override
    public String delete(Long id) {
        paisRepository.deleteById(id);
        return "Dato eliminado";
    }
}
