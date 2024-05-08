package org.adrewdev.pf.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.adrewdev.pf.model.LoginRequest;
import org.adrewdev.pf.model.TrabajadorRequest;
import org.adrewdev.pf.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            log.info("Usuario autenticado: {}", loginRequest);
            authService.authenticateUser(loginRequest);
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody TrabajadorRequest request) {
        try {
            log.info("Usuario registrado: {}", request);
            authService.registerUser(request);
            return ResponseEntity.ok(request);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
