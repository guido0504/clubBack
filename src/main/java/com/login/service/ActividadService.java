package com.login.service;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.actividad.AddActividadRequestDTO;
import com.login.dto.actividad.UpdateActividadRequestDTO;
import org.postgresql.util.PSQLException;

public interface ActividadService {
    ResponseDefaultDto findAll();
    ResponseDefaultDto findById(Long id);
    ResponseDefaultDto create(AddActividadRequestDTO addActividadRequestDto) throws PSQLException;
    ResponseDefaultDto update(Long id, UpdateActividadRequestDTO updateActividadRequestDto);
    ResponseDefaultDto delete(Long id);
}
