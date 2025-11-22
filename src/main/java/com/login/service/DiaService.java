package com.login.service;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.dia.AddDiaRequestDTO;
import com.login.dto.dia.UpdateDiaRequestDTO;
import org.postgresql.util.PSQLException;

public interface DiaService {
    ResponseDefaultDto findAll();
    ResponseDefaultDto findById(Long id);
    ResponseDefaultDto create(AddDiaRequestDTO addDiaRequestDTO) throws PSQLException;
    ResponseDefaultDto update(Long id, UpdateDiaRequestDTO updateDiaRequestDTO);
    ResponseDefaultDto delete(Long id);
}
