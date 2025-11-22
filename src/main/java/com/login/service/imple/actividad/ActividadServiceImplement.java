package com.login.service.imple.actividad;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.actividad.ActividadReponseDTO;
import com.login.dto.actividad.AddActividadRequestDTO;
import com.login.dto.actividad.UpdateActividadRequestDTO;
import com.login.dto.dia.AddDiaRequestDTO;
import com.login.dto.dia.DiaResponseDTO;
import com.login.dto.dia.UpdateDiaRequestDTO;
import com.login.entity.actividad.ActividadEntity;
import com.login.entity.dia.DiaEntity;
import com.login.entity.tipoActividad.TipoActividadEntity;
import com.login.repository.ActividadRepository.ActividadRepository;
import com.login.repository.DiaRepository.DiaRepository;
import com.login.repository.TipoActividadRepository.TipoActividadRepository;
import com.login.service.ActividadService;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadServiceImplement implements ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private DiaRepository diaRepository;

    @Autowired
    private TipoActividadRepository tipoActividadRepository;

    @Override
    public ResponseDefaultDto findAll() {
        return new ResponseDefaultDto(200,"Existoso",actividadRepository.findAll(),"Listado completo");
    }

    @Override
    public ResponseDefaultDto findById(Long id) {
        ActividadEntity actividadEntity = actividadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dia no encontrado con ID: " + id));
        return new ResponseDefaultDto(200,"Existoso",convertToDto(actividadEntity),"Valor retornado");
    }

    @Override
    public ResponseDefaultDto create(AddActividadRequestDTO addActividadRequestDto) throws PSQLException {
        try {
            ActividadEntity actividadEntity = convertToEntity(addActividadRequestDto);
            ActividadEntity saveActividad = actividadRepository.save(actividadEntity);
            return new ResponseDefaultDto(200,"Existoso",convertToDto(saveActividad),"Se guardo exitosamente");
        } catch(Exception e){
            return new ResponseDefaultDto(500,"Error","","Error general: " + e);
        }
    }

    @Override
    public ResponseDefaultDto update(Long id, UpdateActividadRequestDTO updateActividadRequestDto) {
        try {
            ActividadEntity actividadEntity = actividadRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Dia no encontrado con ID: " + id));
            actividadEntity.setNombre(updateActividadRequestDto.nombre());
            actividadEntity.setHora(updateActividadRequestDto.hora());
            TipoActividadEntity tipoActividadEntity = tipoActividadRepository.findById(updateActividadRequestDto.idTipoActividad()).orElseThrow(() -> new RuntimeException("Tipo actividad no encontrado con ID: " + updateActividadRequestDto.idTipoActividad()));
            DiaEntity diaEntity = diaRepository.findById(updateActividadRequestDto.idDia()).orElseThrow(() -> new RuntimeException("Dia no encontrado con ID: " + updateActividadRequestDto.idTipoActividad()));
            actividadEntity.setIdTipoActividad(tipoActividadEntity);
            actividadEntity.setIdDia(diaEntity);
            actividadRepository.save(actividadEntity);
            return new ResponseDefaultDto(200,"Existoso",convertToDto(actividadEntity),"Se actualizo exitosamente");
        } catch(Exception e){
            return new ResponseDefaultDto(500,"Error","","Error general: " + e);
        }
    }

    @Override
    public ResponseDefaultDto delete(Long id) {
        actividadRepository.deleteById(id);
        return new ResponseDefaultDto(200,"Exitoso",null,"Dato eliminado exitosamente");
    }

    // --- Métodos de Conversión (Debes implementarlos) ---
    private ActividadEntity convertToEntity(AddActividadRequestDTO dto) {
        TipoActividadEntity tipoActividadEntity = tipoActividadRepository.findById(dto.idTipoActividad()).orElseThrow(() -> new RuntimeException("Tipo actividad no encontrado con ID: " + dto.idTipoActividad()));
        DiaEntity diaEntity = diaRepository.findById(dto.idDia()).orElseThrow(() -> new RuntimeException("Dia no encontrado con ID: " + dto.idTipoActividad()));
        return new ActividadEntity(dto.nombre(),tipoActividadEntity,dto.hora(),diaEntity);
    }

    private ActividadEntity convertToEntity(UpdateActividadRequestDTO dto) {
        TipoActividadEntity tipoActividadEntity = tipoActividadRepository.findById(dto.idTipoActividad()).orElseThrow(() -> new RuntimeException("Tipo actividad no encontrado con ID: " + dto.idTipoActividad()));
        DiaEntity diaEntity = diaRepository.findById(dto.idDia()).orElseThrow(() -> new RuntimeException("Dia no encontrado con ID: " + dto.idTipoActividad()));
        return new ActividadEntity(dto.id(),dto.nombre(),tipoActividadEntity,dto.hora(),diaEntity);
    }

    private ActividadReponseDTO convertToDto(ActividadEntity entity) {
        return new ActividadReponseDTO(entity.getId(),entity.getNombre(),entity.getIdTipoActividad(),entity.getIdDia(),entity.getHora()); // Implementar la lógica real
    }
}
