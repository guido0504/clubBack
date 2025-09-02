package com.login.service.imple.tipoActividad;

import com.login.dto.tipoActividad.TipoActividadRequestCompleteDto;
import com.login.dto.tipoActividad.TipoActividadRequestDto;
import com.login.dto.tipoActividad.TipoActividadResponseDto;
import com.login.entity.tipoActividad.TipoActividadEntity;
import com.login.repository.TipoActividadRepository.TipoActividadRepository;
import com.login.service.TipoActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoActividadServiceImplement implements TipoActividadService {

    @Autowired
    private TipoActividadRepository tipoActividadRepository;

    @Override
    public TipoActividadResponseDto save(TipoActividadRequestDto tipoActividadRequestDto) {
        tipoActividadRepository.save(TipoActividadEntity.tipoActividadEntity(tipoActividadRequestDto));
        return new TipoActividadResponseDto(tipoActividadRepository.count(), tipoActividadRequestDto.nombre());
    }

    @Override
    public List<TipoActividadResponseDto> findAll() {
        return List.of();
    }

    @Override
    public Optional<TipoActividadResponseDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public TipoActividadResponseDto update(TipoActividadRequestCompleteDto tipoActividadRequestCompleteDto) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return "";
    }
}
