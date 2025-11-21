// Se encarga de comunicarse con la BD

package com.login.repository.tipoEventoRepository;

import com.login.entity.tipoEvento.TipoEventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEventoRepository extends JpaRepository<TipoEventoEntity, Long> {
}
