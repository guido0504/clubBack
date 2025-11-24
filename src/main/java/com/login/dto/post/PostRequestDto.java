package com.login.dto.post;

// Nota: Puedes usar anotaciones de Lombok (@Data) si las tienes configuradas.
// Si no, necesitarás Getters, Setters y Constructores manuales.

import java.time.LocalDateTime;

public record PostRequestDto(
        String title,
        String body,
        long tipoEvento,
        LocalDateTime fechaHora,
        String imageUrl,
        String videoUrl
) {}