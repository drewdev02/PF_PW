package org.adrewdev.pf.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TrabajadorNoDocenteRequest extends TrabajadorRequest {
    private String nivelEscolaridad;
    private String ocupacion;

    public TrabajadorNoDocenteRequest(String nombre, String carneIdentidad, String direccion, String nivelEscolaridad, String ocupacion) {
        super(nombre, carneIdentidad, direccion);
        this.nivelEscolaridad = nivelEscolaridad;
        this.ocupacion = ocupacion;
    }
}