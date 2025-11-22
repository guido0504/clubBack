package com.login.service.imple.dia;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.dia.AddDiaRequestDTO;
import com.login.dto.dia.DiaResponseDTO;
import com.login.dto.dia.UpdateDiaRequestDTO;
import com.login.dto.post.PostRequestDto;
import com.login.dto.post.PostResponseDto;
import com.login.entity.dia.DiaEntity;
import com.login.entity.post.Post;
import com.login.repository.DiaRepository.DiaRepository;
import com.login.service.DiaService;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaServiceImplement implements DiaService {

    @Autowired
    private DiaRepository diaRepository;

    @Override
    public ResponseDefaultDto findAll() {
        return new ResponseDefaultDto(200,"Existoso",diaRepository.findAll(),"Listado completo");
    }

    @Override
    public ResponseDefaultDto findById(Long id) {
        DiaEntity diaEntity = diaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dia no encontrado con ID: " + id));
        return new ResponseDefaultDto(200,"Existoso",convertToDto(diaEntity),"Valor retornado");

    }

    @Override
    public ResponseDefaultDto create(AddDiaRequestDTO addDiaRequestDTO) throws PSQLException {
        try {
            DiaEntity diaEntity = convertToEntity(addDiaRequestDTO);
            DiaEntity saveDia = diaRepository.save(diaEntity);
            return new ResponseDefaultDto(200,"Existoso",convertToDto(saveDia),"Se guardo exitosamente");
        } catch(Exception e){
            return new ResponseDefaultDto(500,"Error","","Error general: " + e);
        }
    }

    @Override
    public ResponseDefaultDto update(Long id, UpdateDiaRequestDTO updateDiaRequestDTO) {
        try {
            DiaEntity diaEntity = diaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Dia no encontrado con ID: " + id));
            diaEntity.setNombre(updateDiaRequestDTO.nombre());
            DiaEntity updateDia = diaRepository.save(diaEntity);
            return new ResponseDefaultDto(200,"Existoso",convertToDto(updateDia),"Se actualizo exitosamente");
        } catch(Exception e){
            return new ResponseDefaultDto(500,"Error","","Error general: " + e);
        }
    }

    @Override
    public ResponseDefaultDto delete(Long id) {
        diaRepository.deleteById(id);
        return new ResponseDefaultDto(200,"Exitoso",null,"Dato eliminado exitosamente");    }

    // --- Métodos de Conversión (Debes implementarlos) ---
    private DiaEntity convertToEntity(AddDiaRequestDTO dto) {
        return new DiaEntity(dto.nombre());
    }

    private DiaEntity convertToEntity(UpdateDiaRequestDTO dto) {
        return new DiaEntity(dto.id(),dto.nombre());
    }

    private DiaResponseDTO convertToDto(DiaEntity entity) {
        return new DiaResponseDTO(entity.getId(),entity.getNombre()); // Implementar la lógica real
    }
}
