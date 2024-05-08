package org.adrewdev.pf.repository;

import org.adrewdev.pf.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {

}