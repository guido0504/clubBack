package com.login.dto.post;

// Nota: Puedes usar anotaciones de Lombok (@Data) si las tienes configuradas.
// Si no, necesitarás Getters, Setters y Constructores manuales.

import com.login.entity.tipoEvento.TipoEvento;

public record PostRequestDto(
        String title,
        String body,
        long section,
        String imageUrl,
        String videoUrl
) {}