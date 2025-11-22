package com.login.service;

import com.login.dto.tipoEvento.TipoEventoRequestCompleteDto;
import com.login.dto.tipoEvento.TipoEventoRequestDto;
import com.login.dto.tipoEvento.TipoEventoResponseDto;

import java.util.List;

public interface TipoEventoService {
    // Creamos métodos abstractos (5 tenemos que crear: save, gelAll, getById, update, delete, )
    TipoEventoResponseDto save(TipoEventoRequestDto tipoEvento);
    List<TipoEventoResponseDto> getAll();
    TipoEventoResponseDto getById(Long id);
    TipoEventoResponseDto update(TipoEventoRequestCompleteDto tipoEvento);
    String delete(Long id);

}
