package org.adrewdev.pf.repository;

import org.adrewdev.pf.entity.TrabajadorNoDocente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorNoDocenteRepository extends JpaRepository<TrabajadorNoDocente, Long> {
    void deleteByCarneIdentidad(String ci);
}