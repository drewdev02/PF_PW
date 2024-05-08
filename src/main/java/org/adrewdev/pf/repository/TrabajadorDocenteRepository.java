package org.adrewdev.pf.repository;

import org.adrewdev.pf.entity.TrabajadorDocente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorDocenteRepository extends JpaRepository<TrabajadorDocente, Long> {
}