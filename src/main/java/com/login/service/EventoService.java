package com.login.service;

import com.login.dto.tipoActividad.TipoActividadRequestCompleteDto;
import com.login.dto.tipoActividad.TipoActividadRequestDto;
import com.login.dto.tipoActividad.TipoActividadResponseDto;
import com.login.entity.pais.Pais;
import com.login.entity.tipoEvento.TipoEvento;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EventoService {
    public TipoActividadResponseDto save(TipoActividadRequestDto tipoActividadRequestDto);

    public List<TipoActividadResponseDto> findAll();

    public TipoActividadResponseDto findById(Long id);

    public TipoActividadResponseDto update(TipoActividadRequestCompleteDto tipoActividadRequestCompleteDto);

    public String delete(Long id);
}





