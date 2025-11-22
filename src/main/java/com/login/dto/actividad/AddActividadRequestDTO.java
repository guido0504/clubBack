package com.login.dto.actividad;

import com.login.entity.tipoActividad.TipoActividadEntity;

public record AddActividadRequestDTO(
        String nombre,
        Long idTipoActividad,
        Long idDia,
        String hora
) {}
