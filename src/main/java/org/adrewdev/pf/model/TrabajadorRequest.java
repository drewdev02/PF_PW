package org.adrewdev.pf.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TrabajadorRequest.class, name = "normal"),
        @JsonSubTypes.Type(value = TrabajadorNoDocenteRequest.class, name = "no_docente"),
        @JsonSubTypes.Type(value = TrabajadorDocenteRequest.class, name = "docente")
})
public class TrabajadorRequest {
    private String nombre;
    private String carneIdentidad;
    private List<DireccionRequest> direccion;

    public TrabajadorRequest(String nombre, String carneIdentidad, List<DireccionRequest> direccion) {
        this.nombre = nombre;
        this.carneIdentidad = carneIdentidad;
        this.direccion = direccion;
    }

}