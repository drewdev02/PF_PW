package org.adrewdev.pf.utilis;

import org.adrewdev.pf.entity.TrabajadorDocente;
import org.adrewdev.pf.model.TrabajadorDocenteRequest;

public class Utils {
    private Utils() {
    }

    public static TrabajadorDocente mapper(TrabajadorDocenteRequest request) {
        return new TrabajadorDocente(
                request.getNombre(),
                request.getCarneIdentidad(),
                request.getDireccion(),
                request.getCategoriaDocente(),
                request.getCategoriaCientifica()
        );
    }

    public static TrabajadorDocente mapper(TrabajadorDocenteRequest request) {
        return new TrabajadorDocente(
                request.getNombre(),
                request.getCarneIdentidad(),
                request.getDireccion(),
                request.getCategoriaDocente(),
                request.getCategoriaCientifica()
        );
    }

}
