package com.login.service.imple.tipoActividad;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.tipoActividad.TipoActividadRequestCompleteDto;
import com.login.dto.tipoActividad.TipoActividadRequestDto;
import com.login.dto.tipoActividad.TipoActividadResponseDto;
import com.login.entity.dia.DiaEntity;
import com.login.entity.tipoActividad.TipoActividadEntity;
import com.login.repository.TipoActividadRepository.TipoActividadRepository;
import com.login.service.TipoActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoActividadServiceImplement implements TipoActividadService {

    @Autowired
    private TipoActividadRepository tipoActividadRepository;

    @Override
    public ResponseDefaultDto save(TipoActividadRequestDto tipoActividadRequestDto) {
        try {
            TipoActividadEntity tipoActividadEntity = TipoActividadEntity.tipoActividadEntity(tipoActividadRequestDto);
            return new ResponseDefaultDto(200,"Existoso",TipoActividadResponseDto.convertTo(tipoActividadRepository.save(tipoActividadEntity)),"Se guardo exitosamente");
        } catch(Exception e){
            return new ResponseDefaultDto(500,"Error","","Error general: " + e);
        }
    }

    @Override
    public ResponseDefaultDto findAll() {
        return new ResponseDefaultDto(200,"Existoso",tipoActividadRepository.findAll(),"Listado completo");
    }

    @Override
    public ResponseDefaultDto findById(Long id) {
        TipoActividadEntity tipoActividadEntity = tipoActividadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo actividad no encontrado con ID: " + id));
        return new ResponseDefaultDto(200,"Existoso",TipoActividadResponseDto.convertTo(tipoActividadEntity),"Valor retornado");
    }

    @Override
    public ResponseDefaultDto update(TipoActividadRequestCompleteDto tipoActividadRequestCompleteDto) {
        try {
             TipoActividadEntity tipoActividadEntity = tipoActividadRepository.findById(tipoActividadRequestCompleteDto.id())
                    .orElseThrow(() -> new RuntimeException("Tipo actividad no encontrado con ID: " + tipoActividadRequestCompleteDto.id()));
            tipoActividadEntity.setNombre(tipoActividadRequestCompleteDto.nombre());
            tipoActividadRepository.save(tipoActividadEntity);
            return new ResponseDefaultDto(200,"Existoso",TipoActividadResponseDto.convertTo(tipoActividadEntity),"Se actualizo exitosamente");
        } catch(Exception e){
            return new ResponseDefaultDto(500,"Error","","Error general: " + e);
        }
    }

    @Override
    public ResponseDefaultDto delete(Long id) {
        tipoActividadRepository.deleteById(id);
        return new ResponseDefaultDto(200,"Exitoso",null,"Dato eliminado exitosamente");
    }
}
