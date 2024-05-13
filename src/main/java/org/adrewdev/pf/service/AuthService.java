package org.adrewdev.pf.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.adrewdev.pf.entity.Direccion;
import org.adrewdev.pf.model.LoginRequest;
import org.adrewdev.pf.model.TrabajadorDocenteRequest;
import org.adrewdev.pf.model.TrabajadorNoDocenteRequest;
import org.adrewdev.pf.model.TrabajadorRequest;
import org.adrewdev.pf.repository.*;
import org.adrewdev.pf.utilis.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final DireccionRepository direccionRepository;
    private final TrabajadorRepository trabajadorRepository;
    private final TrabajadorDocenteRepository trabajadorDocenteRepository;
    private final TrabajadorNoDocenteRepository trabajadorNoDocenteRepository;


    public void registerUser(TrabajadorRequest request) throws RuntimeException {
        try {
            var direccion = Optional.ofNullable(request.getDireccion())
                    .orElse(List.of())
                    .stream()
                    .map(d -> new ModelMapper().map(d, Direccion.class))
                    .toList();

            if (request instanceof TrabajadorDocenteRequest) {
                var entity = Mapper.map((TrabajadorDocenteRequest) request);
                var direcciones = direccion.stream().peek(d -> d.setTrabajador(entity)).toList();
                entity.setDirecciones(direcciones);
                trabajadorDocenteRepository.save(entity);
                direccionRepository.saveAll(direccion);

            } else if (request instanceof TrabajadorNoDocenteRequest) {
                var entity = Mapper.map((TrabajadorNoDocenteRequest) request);
                var direcciones = direccion.stream().peek(d -> d.setTrabajador(entity)).toList();
                entity.setDirecciones(direcciones);
                trabajadorNoDocenteRepository.save(entity);
                direccionRepository.saveAll(direccion);

            } else {
                var entity = Mapper.map(request);
                var direcciones = direccion.stream().peek(d -> d.setTrabajador(entity)).toList();
                entity.setDirecciones(direcciones);
                trabajadorRepository.save(entity);
                direccionRepository.saveAll(direccion);
            }
        } catch (Exception e) {
            log.error("Error al registrar usuario", e);
            throw new RuntimeException("Error al registrar usuario");
        }
    }

    public void authenticateUser(LoginRequest loginRequest) throws RuntimeException {
        var user = usuarioRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
    }

    public void createUser(@NonNull LoginRequest loginRequest) {
        var user = Mapper.map(loginRequest);
        usuarioRepository.save(user);
    }
}
