package com.login.service.imple.tipoEvento;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.tipoEvento.TipoEventoRequestCompleteDto;
import com.login.dto.tipoEvento.TipoEventoRequestDto;
import com.login.dto.tipoEvento.TipoEventoResponseDto;
import com.login.entity.dia.DiaEntity;
import com.login.entity.tipoEvento.TipoEventoEntity;
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
    public ResponseDefaultDto save(TipoEventoRequestDto tipoEvento) {
        try {
            TipoEventoEntity tipoEventoEntity = TipoEventoEntity.converTo(tipoEvento);
            tipoEventoRepository.save(tipoEventoEntity);
            return new ResponseDefaultDto(200,"Existoso", TipoEventoResponseDto.convertTo(tipoEventoEntity),"Se guardo exitosamente");
        } catch(Exception e){
            return new ResponseDefaultDto(500,"Error","","Error general: " + e);
        }
    }

    @Override
    public ResponseDefaultDto getAll() {
        return new ResponseDefaultDto(200,"Existoso",tipoEventoRepository.findAll(),"Listado completo");
    }

    @Override
    public ResponseDefaultDto getById(Long id) {
        TipoEventoEntity tipoEventoEntity = tipoEventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo evento no encontrado con ID: " + id));
        return new ResponseDefaultDto(200,"Existoso",TipoEventoResponseDto.convertTo(tipoEventoEntity),"Valor retornado");
    }

    @Override
    public ResponseDefaultDto update(TipoEventoRequestCompleteDto tipoEvento) {
        try {
            TipoEventoEntity tipoEventoEntity = tipoEventoRepository.findById(tipoEvento.id())
                    .orElseThrow(() -> new RuntimeException("Tipo evento no encontrado con ID: " + tipoEvento.id()));
            tipoEventoEntity.setNombre(tipoEvento.nombre());
            tipoEventoRepository.save(tipoEventoEntity);
            return new ResponseDefaultDto(200,"Existoso", TipoEventoResponseDto.convertTo(tipoEventoEntity),"Se actualizo exitosamente");
        } catch(Exception e){
            return new ResponseDefaultDto(500,"Error","","Error general: " + e);
        }
    }

    @Override
    public ResponseDefaultDto delete(Long id) {
        tipoEventoRepository.deleteById(id);
        return new ResponseDefaultDto(200,"Exitoso",null,"Dato eliminado exitosamente");
    }
}
