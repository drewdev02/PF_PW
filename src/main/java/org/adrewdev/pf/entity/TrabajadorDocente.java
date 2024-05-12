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
public class TrabajadorDocente extends Trabajador {
    private String categoriaDocente;
    private String categoriaCientifica;

    public TrabajadorDocente(
            Long id,
            String nombre,
            String carneIdentidad,
            List<Direccion> direccion,
            String categoriaCientifica,
            String categoriaDocente
    ) {
        super(id, nombre, carneIdentidad, direccion);
        this.categoriaCientifica = categoriaCientifica;
        this.categoriaDocente = categoriaDocente;
    }
    public TrabajadorDocente(String nombre, String carneIdentidad, String categoriaDocente, String categoriaCientifica) {
        super(nombre, carneIdentidad);
        this.categoriaDocente = categoriaDocente;
        this.categoriaCientifica = categoriaCientifica;
    }
}