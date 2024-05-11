package org.adrewdev.pf.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.adrewdev.pf.entity.Direccion;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class TrabajadorDocenteRequest extends TrabajadorRequest {
    private String categoriaDocente;
    private String categoriaCientifica;

    public TrabajadorDocenteRequest(String nombre, String carneIdentidad, List<DireccionRequest> direccion, String categoriaDocente,
                                    String categoriaCientifica) {
        super(nombre, carneIdentidad, direccion);
        this.categoriaDocente = categoriaDocente;
        this.categoriaCientifica = categoriaCientifica;
    }
}