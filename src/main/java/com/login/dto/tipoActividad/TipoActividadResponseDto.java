package com.login.dto.tipoActividad;

import com.login.entity.tipoActividad.TipoActividadEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record TipoActividadResponseDto(
        Long id,
        String nombre
) {

    public static  List<TipoActividadResponseDto> convertTo(List<TipoActividadEntity> lista){
        List<TipoActividadResponseDto> listaTipoActividad = new ArrayList<>();
        lista.forEach(l -> listaTipoActividad.add(new TipoActividadResponseDto(
                l.getId(),l.getNombre()
        )));
        return listaTipoActividad;
    }

    public static TipoActividadResponseDto convertTo(TipoActividadEntity tipoActividadEntity){
        return new TipoActividadResponseDto(tipoActividadEntity.getId(),tipoActividadEntity.getNombre());
    }
}
