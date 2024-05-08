package org.adrewdev.pf.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    private String direccion;

    public TrabajadorRequest(String nombre, String carneIdentidad, String direccion) {
        this.nombre = nombre;
        this.carneIdentidad = carneIdentidad;
        this.direccion = direccion;
    }

}