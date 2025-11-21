package com.login.entity.actividad;

import com.login.entity.tipoActividad.TipoActividadEntity;
import jakarta.persistence.*;

@Entity
@Table(name="actividad")
public class ActividadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_actividad_id")
    private TipoActividadEntity idActividad;
}
