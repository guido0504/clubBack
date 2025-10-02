// Lo que devolvemos en las respuestas

package com.login.dto.tipoEvento;

public record TipoEventoResponseDto(
        Long id,
        String nombre
) {

    public static TipoEventoResponseDto convertTo(TipoEventoRequestDto tipoEventoRequestDto){
        return new TipoEventoResponseDto(0L,tipoEventoRequestDto.npmbre());
    }
}
