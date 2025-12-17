// Lo que devolvemos en las respuestas

package com.login.dto.tipoEvento;

import com.login.entity.tipoEvento.TipoEventoEntity;

import java.util.ArrayList;
import java.util.List;

public record TipoEventoResponseDto(
        Long id,
        String nombre
) {

    public static TipoEventoResponseDto convertTo(TipoEventoRequestDto tipoEventoRequestDto){
        return new TipoEventoResponseDto(0L,tipoEventoRequestDto.nombre());
    }

    public static TipoEventoResponseDto convertTo(TipoEventoEntity tipoEvento){
        return new TipoEventoResponseDto(tipoEvento.getId(), tipoEvento.getNombre());
    }

    public static List<TipoEventoResponseDto> convertTo(List<TipoEventoEntity> lista){
        List<TipoEventoResponseDto> listaEvento = new ArrayList<>();
        lista.forEach(l -> listaEvento.add(new TipoEventoResponseDto(l.getId(),l.getNombre())));
        return listaEvento;
    }
}
