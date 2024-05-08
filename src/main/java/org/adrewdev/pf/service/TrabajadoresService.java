package org.adrewdev.pf.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.adrewdev.pf.model.TrabajadorDocenteRequest;
import org.adrewdev.pf.model.TrabajadorNoDocenteRequest;
import org.adrewdev.pf.model.TrabajadorRequest;
import org.adrewdev.pf.repository.TrabajadorDocenteRepository;
import org.adrewdev.pf.repository.TrabajadorNoDocenteRepository;
import org.adrewdev.pf.repository.TrabajadorRepository;
import org.adrewdev.pf.utilis.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TrabajadoresService {
    private final TrabajadorRepository trabajadorRepository;
    private final TrabajadorDocenteRepository trabajadorDocenteRepository;
    private final TrabajadorNoDocenteRepository trabajadorNoDocenteRepository;

    public List<TrabajadorRequest> getAllTrabajadoresSortAlfabeticamente() {
        return trabajadorRepository.findAll().stream()
                .map(Mapper::map)
                .toList();
    }

    public List<TrabajadorDocenteRequest> getAllTrabajadoresDocentes() {
        return trabajadorDocenteRepository.findAll().stream()
                .map(Mapper::map)
                .toList();
    }

    public List<TrabajadorNoDocenteRequest> getAllTrabajadoresNoDocentes() {
        return trabajadorNoDocenteRepository.findAll().stream()
                .map(Mapper::map)
                .toList();
    }
}
