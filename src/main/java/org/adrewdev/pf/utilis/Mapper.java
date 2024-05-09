package org.adrewdev.pf.utilis;

import org.adrewdev.pf.entity.Trabajador;
import org.adrewdev.pf.entity.TrabajadorDocente;
import org.adrewdev.pf.entity.TrabajadorNoDocente;
import org.adrewdev.pf.entity.Usuario;
import org.adrewdev.pf.model.LoginRequest;
import org.adrewdev.pf.model.TrabajadorDocenteRequest;
import org.adrewdev.pf.model.TrabajadorNoDocenteRequest;
import org.adrewdev.pf.model.TrabajadorRequest;
import org.modelmapper.ModelMapper;

public class Mapper {
    private static final ModelMapper modelMapper = new ModelMapper();

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

    public static TrabajadorRequest map(Trabajador trabajador) {
        return new TrabajadorRequest(
                trabajador.getNombre(),
                trabajador.getCarneIdentidad(),
                trabajador.getDireccion()
        );
    }

    public static TrabajadorDocenteRequest map(TrabajadorDocente trabajador) {
        return new TrabajadorDocenteRequest(
                trabajador.getNombre(),
                trabajador.getCarneIdentidad(),
                trabajador.getDireccion(),
                trabajador.getCategoriaDocente(),
                trabajador.getCategoriaCientifica()
        );
    }

    public static TrabajadorNoDocenteRequest map(TrabajadorNoDocente trabajador) {
        return new TrabajadorNoDocenteRequest(
                trabajador.getNombre(),
                trabajador.getCarneIdentidad(),
                trabajador.getDireccion(),
                trabajador.getNivelEscolaridad(),
                trabajador.getOcupacion()
        );
    }

    public static Usuario map(LoginRequest user) {
        return modelMapper.map(user, Usuario.class);
    }


}
