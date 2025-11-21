package com.login.dto.post;

import com.login.entity.tipoEvento.TipoEventoEntity;

import java.time.LocalDateTime;

public record PostResponseDto(
        Long id,
        String title,
        String body,
        TipoEventoEntity section,
        String imageUrl,
        String videoUrl,
        LocalDateTime createdAt){
}