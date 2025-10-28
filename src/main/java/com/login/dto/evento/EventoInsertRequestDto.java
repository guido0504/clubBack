package com.login.dto.evento;

import java.util.Date;

public record EventoInsertRequestDto(
        String direccion,
        Date fechaEvento,
        String horaEvento,
        String localidad,
        Date fechaCreacion,
        String descripcion,
        String titulo,
        String informacion
) {
}
