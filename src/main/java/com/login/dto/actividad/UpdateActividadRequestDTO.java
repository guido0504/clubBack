package com.login.dto.actividad;

public record UpdateActividadRequestDTO(
        Long id,
        String nombre,
        Long idTipoActividad,
        Long idDia,
        String hora
) {
}
