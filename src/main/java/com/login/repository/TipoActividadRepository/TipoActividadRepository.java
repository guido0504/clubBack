package com.login.repository.TipoActividadRepository;

import com.login.entity.tipoActividad.TipoActividadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoActividadRepository extends JpaRepository<TipoActividadEntity,Long> {
}
