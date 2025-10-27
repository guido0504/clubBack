// Representa la tabla en la BD

package com.login.entity.tipoEvento;

import com.login.dto.tipoEvento.TipoEventoRequestCompleteDto;
import com.login.dto.tipoEvento.TipoEventoRequestDto;
import com.login.entity.evento.Evento;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tipo-evento")
public class TipoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Autoincremental
    private long id;
    private String nombre;

    @OneToMany(mappedBy = "tipoEvento")
    private List<Evento> evento;

    // Constructor vacío (Obligatorio para JPA)
    public TipoEvento() {
    }

    // Constructor con parámetros
    public TipoEvento(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Constructor con parámetros
    public TipoEvento(String nombre) {
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

    public static TipoEvento converTo(TipoEventoRequestDto tipoEventoRequestDto){
        return new TipoEvento(tipoEventoRequestDto.npmbre());
    }

    public static TipoEvento converTo(TipoEventoRequestCompleteDto tipoEventoRequestDto){
        return new TipoEvento(tipoEventoRequestDto.id(), tipoEventoRequestDto.nombre());
    }

    public List<Evento> getEvento() {
        return evento;
    }

    public void setEvento(List<Evento> evento) {
        this.evento = evento;
    }
}
