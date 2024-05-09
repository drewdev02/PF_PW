package org.adrewdev.pf.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.adrewdev.pf.service.TrabajadoresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/trabajador")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class TrabajadoresController {
    private final TrabajadoresService trabajadoresService;

    @GetMapping
    public ResponseEntity<?> getAllTrabajadores() {
        try {
            var list = trabajadoresService.getAllTrabajadoresSortAlfabeticamente();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            log.error("Error al obtener trabajadores", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/docentes")
    public ResponseEntity<?> getAllTrabajadoresDocentes() {
        try {
            var list = trabajadoresService.getAllTrabajadoresDocentes();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            log.error("Error al obtener trabajadores docentes", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/nodocentes")
    public ResponseEntity<?> getAllTrabajadoresNoDocentes() {
        try {
            var list = trabajadoresService.getAllTrabajadoresNoDocentes();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            log.error("Error al obtener trabajadores no docentes", e);
            return ResponseEntity.badRequest().build();
        }
    }

}
