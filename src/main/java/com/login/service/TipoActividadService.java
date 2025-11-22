package com.login.service;

import com.login.dto.tipoActividad.TipoActividadRequestCompleteDto;
import com.login.dto.tipoActividad.TipoActividadRequestDto;
import com.login.dto.tipoActividad.TipoActividadResponseDto;

import java.util.List;
import java.util.Optional;

public interface TipoActividadService {

    TipoActividadResponseDto save(TipoActividadRequestDto tipoActividadRequestDto);

    List<TipoActividadResponseDto> findAll();

    TipoActividadResponseDto findById(Long id);

    TipoActividadResponseDto update(TipoActividadRequestCompleteDto tipoActividadRequestCompleteDto);

    String delete(Long id);
}
