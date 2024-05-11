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
        return modelMapper.map(request, TrabajadorDocente.class);
    }

    public static TrabajadorNoDocente map(TrabajadorNoDocenteRequest request) {
        return modelMapper.map(request, TrabajadorNoDocente.class);
    }

    public static Trabajador map(TrabajadorRequest request) {
        return modelMapper.map(request, Trabajador.class);
    }

    public static TrabajadorRequest map(Trabajador trabajador) {
        return modelMapper.map(trabajador, TrabajadorRequest.class);
    }

    public static TrabajadorDocenteRequest map(TrabajadorDocente trabajador) {
        return modelMapper.map(trabajador, TrabajadorDocenteRequest.class);
    }

    public static TrabajadorNoDocenteRequest map(TrabajadorNoDocente trabajador) {
        return modelMapper.map(trabajador, TrabajadorNoDocenteRequest.class);
    }

    public static Usuario map(LoginRequest user) {
        return modelMapper.map(user, Usuario.class);
    }


}
