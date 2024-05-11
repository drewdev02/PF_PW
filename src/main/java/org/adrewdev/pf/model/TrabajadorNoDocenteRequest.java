package org.adrewdev.pf.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.adrewdev.pf.entity.Direccion;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class TrabajadorNoDocenteRequest extends TrabajadorRequest {
    private String nivelEscolaridad;
    private String ocupacion;

    public TrabajadorNoDocenteRequest(
            String nombre,
            String carneIdentidad,
            List<DireccionRequest> direccion,
            String nivelEscolaridad,
            String ocupacion
    ) {
        super(nombre, carneIdentidad, direccion);
        this.nivelEscolaridad = nivelEscolaridad;
        this.ocupacion = ocupacion;
    }
}