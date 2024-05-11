package org.adrewdev.pf.repository;

import org.adrewdev.pf.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
    List<Direccion> findByTrabajador_id(Long trabajadorId);

}