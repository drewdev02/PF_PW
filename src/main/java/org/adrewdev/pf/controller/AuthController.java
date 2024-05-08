package org.adrewdev.pf.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.adrewdev.pf.model.LoginRequest;
import org.adrewdev.pf.model.TrabajadorRequest;
import org.adrewdev.pf.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            authService.authenticateUser(loginRequest);
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } catch (Exception e) {
            log.error("Error al autenticar usuario: {}", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody LoginRequest loginRequest) {
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
        try {
            authService.registerUser(request);
            return ResponseEntity.ok(request);
        } catch (Exception e) {
            log.error("Error al registrar usuario: {}", e);
            return ResponseEntity.badRequest().build();
        }
    }
}
