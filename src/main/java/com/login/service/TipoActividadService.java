package com.login.service;

import com.login.dto.tipoActividad.TipoActividadRequestCompleteDto;
import com.login.dto.tipoActividad.TipoActividadRequestDto;
import com.login.dto.tipoActividad.TipoActividadResponseDto;

import java.util.List;
import java.util.Optional;

public interface TipoActividadService {

    public TipoActividadResponseDto save(TipoActividadRequestDto tipoActividadRequestDto);

    public List<TipoActividadResponseDto> findAll();

    public Optional<TipoActividadResponseDto> findById(Long id);

    public TipoActividadResponseDto update(TipoActividadRequestCompleteDto tipoActividadRequestCompleteDto);

    public String delete(Long id);
}
