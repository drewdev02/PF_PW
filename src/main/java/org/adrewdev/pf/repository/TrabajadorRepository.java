package org.adrewdev.pf.repository;

import org.adrewdev.pf.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    void deleteByCarneIdentidad(String ci);

    @Override
    @Query("SELECT t FROM Trabajador t ORDER BY t.nombre ASC")
    List<Trabajador> findAll();
}