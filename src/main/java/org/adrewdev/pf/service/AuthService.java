package org.adrewdev.pf.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.adrewdev.pf.model.LoginRequest;
import org.adrewdev.pf.model.TrabajadorDocenteRequest;
import org.adrewdev.pf.model.TrabajadorNoDocenteRequest;
import org.adrewdev.pf.model.TrabajadorRequest;
import org.adrewdev.pf.repository.TrabajadorDocenteRepository;
import org.adrewdev.pf.repository.TrabajadorNoDocenteRepository;
import org.adrewdev.pf.repository.TrabajadorRepository;
import org.adrewdev.pf.repository.UsuarioRepository;
import org.adrewdev.pf.utilis.Mapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AuthService {
    private final TrabajadorRepository trabajadorRepository;
    private final TrabajadorDocenteRepository trabajadorDocenteRepository;
    private final TrabajadorNoDocenteRepository trabajadorNoDocenteRepository;
    private final UsuarioRepository usuarioRepository;


    public void registerUser(TrabajadorRequest request) throws RuntimeException {
        try {
            if (request instanceof TrabajadorDocenteRequest) {
                var entity = Mapper.map((TrabajadorDocenteRequest) request);
                trabajadorDocenteRepository.save(entity);

            } else if (request instanceof TrabajadorNoDocenteRequest) {

                var entity = Mapper.map((TrabajadorNoDocenteRequest) request);
                trabajadorNoDocenteRepository.save(entity);
            } else {

                var entity = Mapper.map(request);
                trabajadorRepository.save(entity);
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
