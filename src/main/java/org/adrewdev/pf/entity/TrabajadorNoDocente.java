package org.adrewdev.pf.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class TrabajadorNoDocente extends Trabajador {
    private String nivelEscolaridad;
    private String ocupacion;

    public TrabajadorNoDocente(
            Long id,
            String nombre,
            String carneIdentidad,
            List<Direccion> direccion,
            String nivelEscolaridad,
            String ocupacion
    ) {
        super(id, nombre, carneIdentidad, direccion);
        this.nivelEscolaridad = nivelEscolaridad;
        this.ocupacion = ocupacion;
    }
}