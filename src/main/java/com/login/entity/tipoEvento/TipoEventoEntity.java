// Representa la tabla en la BD

package com.login.entity.tipoEvento;

import com.login.dto.tipoEvento.TipoEventoRequestCompleteDto;
import com.login.dto.tipoEvento.TipoEventoRequestDto;
import jakarta.persistence.*;

@Entity
@Table(name="tipo-evento")
public class TipoEventoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Autoincremental
    private long id;

    @Column(name = "nombre")
    private String nombre;

    //@OneToMany(mappedBy = "tipoEvento")
    //private List<Evento> evento;

    // Constructor vacío (Obligatorio para JPA)
    public TipoEventoEntity() {
    }

    // Constructor con parámetros
    public TipoEventoEntity(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Constructor con parámetros
    public TipoEventoEntity(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
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

    // Repository conecta nuestro proyecto con la BD

    public static TipoEventoEntity converTo(TipoEventoRequestDto tipoEventoRequestDto){
        return new TipoEventoEntity(tipoEventoRequestDto.npmbre());
    }

    public static TipoEventoEntity converTo(TipoEventoRequestCompleteDto tipoEventoRequestDto){
        return new TipoEventoEntity(tipoEventoRequestDto.id(), tipoEventoRequestDto.nombre());
    }

    /*public List<Evento> getEvento() {
        return evento;
    }

    public void setEvento(List<Evento> evento) {
        this.evento = evento;
    }*/
}
