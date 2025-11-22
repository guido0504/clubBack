package com.login.service;

import com.login.dto.tipoActividad.TipoActividadRequestCompleteDto;
import com.login.dto.tipoActividad.TipoActividadRequestDto;
import com.login.dto.tipoActividad.TipoActividadResponseDto;

import java.util.List;

public interface EventoService {
    TipoActividadResponseDto save(TipoActividadRequestDto tipoActividadRequestDto);

    List<TipoActividadResponseDto> findAll();

    TipoActividadResponseDto findById(Long id);

    TipoActividadResponseDto update(TipoActividadRequestCompleteDto tipoActividadRequestCompleteDto);

    String delete(Long id);
}





