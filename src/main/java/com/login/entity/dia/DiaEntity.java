package com.login.entity.dia;

import com.login.entity.actividad.ActividadEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="actividad")
public class DiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "idDia")
    private List<ActividadEntity> listActividad;

    public DiaEntity() {
    }

    public DiaEntity(String nombre){
        this.nombre = nombre;
    }

    public DiaEntity(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public List<ActividadEntity> getListActividad() {
        return listActividad;
    }

    public void setListActividad(List<ActividadEntity> listActividad) {
        this.listActividad = listActividad;
    }
}
