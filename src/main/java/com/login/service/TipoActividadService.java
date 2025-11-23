package com.login.service;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.tipoActividad.TipoActividadRequestCompleteDto;
import com.login.dto.tipoActividad.TipoActividadRequestDto;
import com.login.dto.tipoActividad.TipoActividadResponseDto;

import java.util.List;
import java.util.Optional;

public interface TipoActividadService {

    ResponseDefaultDto save(TipoActividadRequestDto tipoActividadRequestDto);

    ResponseDefaultDto findAll();

    ResponseDefaultDto findById(Long id);

    ResponseDefaultDto update(TipoActividadRequestCompleteDto tipoActividadRequestCompleteDto);

    ResponseDefaultDto delete(Long id);
}
