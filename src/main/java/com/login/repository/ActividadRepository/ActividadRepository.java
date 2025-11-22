package com.login.repository.ActividadRepository;

import com.login.entity.actividad.ActividadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends JpaRepository<ActividadEntity,Long> {
}
