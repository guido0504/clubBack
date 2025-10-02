package com.login.service.imple.tipoEvento;

import com.login.dto.tipoEvento.TipoEventoRequestCompleteDto;
import com.login.dto.tipoEvento.TipoEventoRequestDto;
import com.login.dto.tipoEvento.TipoEventoResponseDto;
import com.login.entity.tipoEvento.TipoEvento;
import com.login.repository.tipoEventoRepository.TipoEventoRepository;
import com.login.service.TipoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoEventoServiceImplement implements TipoEventoService {

    @Autowired
    TipoEventoRepository tipoEventoRepository;



    @Override
    public TipoEventoResponseDto save(TipoEventoRequestDto tipoEvento) {
        tipoEventoRepository.save(TipoEvento.converTo(tipoEvento));
        return TipoEventoResponseDto.convertTo(tipoEvento);
    }

    @Override
    public List<TipoEventoResponseDto> getAll() {
        return List.of();
    }

    @Override
    public TipoEventoResponseDto getById(Long id) {
        return null;
    }

    @Override
    public TipoEventoResponseDto update(TipoEventoRequestCompleteDto tipoEvento) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return "";
    }
}
