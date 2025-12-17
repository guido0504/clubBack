package com.login.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.login.entity.image.ImageEntity;
import com.login.entity.tipoEvento.TipoEventoEntity;

import java.time.LocalDateTime;

public record PostResponseDto(
        Long id,
        String title,
        String body,
        TipoEventoEntity tipoEvento,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
        LocalDateTime fechaHora,
        String imageUrl,
        Long idImage,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
        LocalDateTime createdAt){
}