package org.adrewdev.pf.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.adrewdev.pf.model.LoginRequest;
import org.adrewdev.pf.model.TrabajadorRequest;
import org.adrewdev.pf.service.AuthService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid LoginRequest loginRequest) {
        log.info("Autenticando usuario: {}", loginRequest);
        try {
            authService.authenticateUser(loginRequest);
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } catch (Exception e) {
            log.error("Error al autenticar usuario: {}", e);
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
        }
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody LoginRequest loginRequest) {
        log.info("Creando usuario: {}", loginRequest);
        try {
            authService.createUser(loginRequest);
            return ResponseEntity.ok("Usuario creado exitosamente");
        } catch (Exception e) {
            log.error("error creando usuario: {}", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody TrabajadorRequest request) {
        log.info("Registrando usuario: {}", request);
        try {
            authService.registerUser(request);
            return ResponseEntity.ok(request);
        } catch (Exception e) {
            log.error("Error al registrar usuario: {}", e);
            return ResponseEntity.badRequest().build();
        }
    }
}
