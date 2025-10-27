package com.login.entity.evento;

import com.login.entity.tipoEvento.TipoEvento;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "tipo_evento_id")
    private TipoEvento tipoEvento;

    private Date fechaEvento;

    private String direccion;

    private String localidad;

    private String horaEvento;

    private Date fechaCreacion;

    private String informacion;

    private String descripcion;

    private String titulo;
}
