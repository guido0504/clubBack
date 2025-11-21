package com.login.dto.post;

// Nota: Puedes usar anotaciones de Lombok (@Data) si las tienes configuradas.
// Si no, necesitarás Getters, Setters y Constructores manuales.

public record PostRequestDto(
        String title,
        String body,
        long section,
        String imageUrl,
        String videoUrl
) {}