package com.login.repository.EventoRepository;

import com.login.entity.evento.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    /*@Query("select e.titulo, te.descripcion from Evento e inner join tipo_evento te on te.od = e.tipo_evento_id where tipo_evento_id =  :idTipoEvento")
    public List<Evento> getListByIdTipoEvento(@Param("idTipoEvento") long id_tipo_evento);*/

}
