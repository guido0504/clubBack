package com.login.dto.evento;

import java.util.Date;

public record EventoUpdateRequestDto(
        long id,
        Date fechaEvento,
        String horaEvento,
        String localidad,
        Date fechaCreacion,
        String descripcion,
        String titulo,
        String informacion
) {
}
