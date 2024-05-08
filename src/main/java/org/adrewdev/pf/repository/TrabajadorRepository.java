package org.adrewdev.pf.repository;

import org.adrewdev.pf.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {

}