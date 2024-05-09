package org.adrewdev.pf.model;

import lombok.*;

@Getter
@Setter
@ToString
public class TrabajadorDocenteRequest extends TrabajadorRequest {
    private String categoriaDocente;
    private String categoriaCientifica;

    public TrabajadorDocenteRequest(String nombre, String carneIdentidad, String direccion, String categoriaDocente, String categoriaCientifica) {
        super(nombre, carneIdentidad, direccion);
        this.categoriaDocente = categoriaDocente;
        this.categoriaCientifica = categoriaCientifica;
    }
}