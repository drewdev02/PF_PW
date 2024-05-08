package org.adrewdev.pf.utilis;

import org.adrewdev.pf.entity.Trabajador;
import org.adrewdev.pf.entity.TrabajadorDocente;
import org.adrewdev.pf.entity.TrabajadorNoDocente;
import org.adrewdev.pf.model.TrabajadorDocenteRequest;
import org.adrewdev.pf.model.TrabajadorNoDocenteRequest;
import org.adrewdev.pf.model.TrabajadorRequest;

public class Mapper {
    private Mapper() {
    }

    public static TrabajadorDocente map(TrabajadorDocenteRequest request) {
        return TrabajadorDocente.builder()
                .nombre(request.getNombre())
                .carneIdentidad(request.getCarneIdentidad())
                .direccion(request.getDireccion())
                .categoriaDocente(request.getCategoriaDocente())
                .categoriaCientifica(request.getCategoriaCientifica())
                .build();

    }

    public static TrabajadorNoDocente map(TrabajadorNoDocenteRequest request) {
        return TrabajadorNoDocente.builder()
                .nombre(request.getNombre())
                .carneIdentidad(request.getCarneIdentidad())
                .direccion(request.getDireccion())
                .nivelEscolaridad(request.getNivelEscolaridad())
                .ocupacion(request.getOcupacion())
                .build();
    }

    public static Trabajador map(TrabajadorRequest request) {
        return Trabajador.builder()
                .nombre(request.getNombre())
                .carneIdentidad(request.getCarneIdentidad())
                .direccion(request.getDireccion())
                .build();
    }


}
