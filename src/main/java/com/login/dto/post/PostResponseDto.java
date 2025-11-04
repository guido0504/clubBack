package com.login.dto.post;

import com.login.entity.tipoEvento.TipoEvento;

import java.time.LocalDateTime;

public record PostResponseDto(
        Long id,
        String title,
        String body,
        TipoEvento section,
        String imageUrl,
        String videoUrl,
        LocalDateTime createdAt){
}