package com.login.entity.tipoActividad;

import com.login.dto.tipoActividad.TipoActividadRequestCompleteDto;
import com.login.dto.tipoActividad.TipoActividadRequestDto;
import com.login.dto.tipoActividad.TipoActividadResponseDto;
import jakarta.persistence.*;

@Entity
@Table(name = "tipo_actividad")
public class TipoActividadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    public TipoActividadEntity(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoActividadEntity(String nombre) {
        this.nombre = nombre;
    }

    public TipoActividadEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static TipoActividadEntity tipoActividadEntity(TipoActividadRequestDto tipoActividadRequestDto){
        return new TipoActividadEntity(tipoActividadRequestDto.nombre());
    }

    public static TipoActividadEntity tipoActividadEntity(TipoActividadRequestCompleteDto tipoActividadRequestCompleteDto){
        return new TipoActividadEntity(tipoActividadRequestCompleteDto.id(),tipoActividadRequestCompleteDto.nombre());
    }
}
