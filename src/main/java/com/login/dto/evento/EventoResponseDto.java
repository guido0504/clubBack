package com.login.dto.evento;

import java.util.Date;

public record EventoResponseDto(
        long id,
        String direccion,
        String localidad,
        Date fechaCreacion,
        String descripcion,
        String titulo,
        String informacion
) {
}
