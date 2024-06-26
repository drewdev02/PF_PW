package org.adrewdev.pf.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.adrewdev.pf.entity.Trabajador;
import org.adrewdev.pf.model.DireccionRequest;
import org.adrewdev.pf.model.TrabajadorDocenteRequest;
import org.adrewdev.pf.model.TrabajadorNoDocenteRequest;
import org.adrewdev.pf.model.TrabajadorRequest;
import org.adrewdev.pf.repository.DireccionRepository;
import org.adrewdev.pf.repository.TrabajadorDocenteRepository;
import org.adrewdev.pf.repository.TrabajadorNoDocenteRepository;
import org.adrewdev.pf.repository.TrabajadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TrabajadoresService {

    private final DireccionRepository direccionRepository;
    private final TrabajadorRepository trabajadorRepository;
    private final TrabajadorDocenteRepository trabajadorDocenteRepository;
    private final TrabajadorNoDocenteRepository trabajadorNoDocenteRepository;

    public List<TrabajadorRequest> getAllTrabajadoresSortAlfabeticamente() {
        return trabajadorRepository.findAll().stream().map(t -> {
                    var direcciones = getDirecciones(t.getId());
                    return new TrabajadorRequest(t.getNombre(), t.getCarneIdentidad(), direcciones);
                })
                .toList();
    }

    public List<TrabajadorDocenteRequest> getAllTrabajadoresDocentes() {
        return trabajadorDocenteRepository.findAll().stream().map(t -> {
                    var direcciones = getDirecciones(t.getId());
                    return new TrabajadorDocenteRequest(t.getNombre(), t.getCarneIdentidad(), direcciones,
                            t.getCategoriaDocente(), t.getCategoriaCientifica());
                })
                .toList();
    }

    public List<TrabajadorNoDocenteRequest> getAllTrabajadoresNoDocentes() {
        return trabajadorNoDocenteRepository.findAll().stream().map(t -> {
                    var direc = getDirecciones(t.getId());
                    return new TrabajadorNoDocenteRequest(t.getNombre(), t.getCarneIdentidad(), direc,
                            t.getNivelEscolaridad(), t.getOcupacion());
                })
                .toList();
    }

    public void deleteTrabajador(Long id) {
        try {
            trabajadorRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar trabajador; id: " + id);
        }
    }

    private List<DireccionRequest> getDirecciones(Long trabajadorId) {
        return direccionRepository.findByTrabajador_id(trabajadorId).stream()
                .map(d -> new ModelMapper().map(d, DireccionRequest.class))
                .toList();
    }
}
