package com.login.dto.actividad;

import com.login.dto.dia.DiaResponseDTO;
import com.login.dto.tipoActividad.TipoActividadResponseDto;
import com.login.entity.dia.DiaEntity;
import com.login.entity.tipoActividad.TipoActividadEntity;

public record ActividadReponseDTO(
        Long id,
        String nombre,
        TipoActividadEntity idTipoActividad,
        DiaEntity idDia,
        String hora
) {
}
