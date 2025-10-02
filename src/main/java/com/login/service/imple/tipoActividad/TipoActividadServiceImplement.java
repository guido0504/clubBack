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
        return TipoActividadResponseDto.convertTo(tipoActividadRepository.findAll());
    }

    @Override
    public TipoActividadResponseDto findById(Long id) {
        return TipoActividadResponseDto.convertTo(tipoActividadRepository.getReferenceById(id));
    }

    @Override
    public TipoActividadResponseDto update(TipoActividadRequestCompleteDto tipoActividadRequestCompleteDto) {
        tipoActividadRepository.save(TipoActividadEntity.tipoActividadEntity(tipoActividadRequestCompleteDto));
        return new TipoActividadResponseDto(tipoActividadRepository.count(), tipoActividadRequestCompleteDto.nombre());
    }

    @Override
    public String delete(Long id) {
        tipoActividadRepository.deleteById(id);
        return "Tipo de actividad con ID " + id + " eliminado con éxito.";
    }
}
