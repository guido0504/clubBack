package com.login.service;

import com.login.dto.tipoEvento.TipoEventoRequestCompleteDto;
import com.login.dto.tipoEvento.TipoEventoRequestDto;
import com.login.dto.tipoEvento.TipoEventoResponseDto;

import java.util.List;

public interface TipoEventoService {
    // Creamos métodos abstractos (5 tenemos que crear: save, gelAll, getById, update, delete, )
    public TipoEventoResponseDto save(TipoEventoRequestDto tipoEvento);
    public List<TipoEventoResponseDto> getAll();
    public TipoEventoResponseDto getById(Long id);
    public TipoEventoResponseDto update(TipoEventoRequestCompleteDto tipoEvento);
    public String delete(Long id);

}
