package com.login.service;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.tipoEvento.TipoEventoRequestCompleteDto;
import com.login.dto.tipoEvento.TipoEventoRequestDto;
import com.login.dto.tipoEvento.TipoEventoResponseDto;

import java.util.List;

public interface TipoEventoService {
    ResponseDefaultDto save(TipoEventoRequestDto tipoEvento);
    ResponseDefaultDto getAll();
    ResponseDefaultDto getById(Long id);
    ResponseDefaultDto update(TipoEventoRequestCompleteDto tipoEvento);
    ResponseDefaultDto delete(Long id);

}
