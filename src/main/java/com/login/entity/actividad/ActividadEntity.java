package com.login.entity.actividad;

import com.login.entity.dia.DiaEntity;
import com.login.entity.tipoActividad.TipoActividadEntity;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="actividad")
public class ActividadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_actividad_id")
    private TipoActividadEntity idTipoActividad;

    private String hora;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dia")
    private DiaEntity idDia;

    public ActividadEntity() {
    }

    public ActividadEntity(String nombre, TipoActividadEntity idTipoActividad, String hora, DiaEntity idDia) {
        this.nombre = nombre;
        this.idTipoActividad = idTipoActividad;
        this.hora = hora;
        this.idDia = idDia;
    }

    public ActividadEntity(long id, String nombre, TipoActividadEntity idTipoActividad, String hora, DiaEntity idDia) {
        this.id = id;
        this.nombre = nombre;
        this.idTipoActividad = idTipoActividad;
        this.hora = hora;
        this.idDia = idDia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoActividadEntity getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setIdTipoActividad(TipoActividadEntity idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public DiaEntity getIdDia() {
        return idDia;
    }

    public void setIdDia(DiaEntity idDia) {
        this.idDia = idDia;
    }
}
