package com.login.dto.post;

// Nota: Puedes usar anotaciones de Lombok (@Data) si las tienes configuradas.
// Si no, necesitarás Getters, Setters y Constructores manuales.

import com.fasterxml.jackson.annotation.JsonFormat;
import com.login.entity.image.ImageEntity;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public record PostRequestDto(
        String title,
        String body,
        long tipoEvento,
        OffsetDateTime fechaHora,
        Long image
) {}