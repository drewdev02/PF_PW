package org.adrewdev.pf.utilis;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.adrewdev.pf.model.*;
import org.adrewdev.pf.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Component
public class GenerateData implements Runnable {
    @Autowired
    AuthService authService;

    public List<LoginRequest> generateUsers(int cont) {
        return IntStream.range(0, cont).mapToObj(i -> {
            var faker = new Faker();
            var name = faker.name().firstName().toLowerCase();
            var password = faker.internet().password();
            return new LoginRequest(name, password);
        }).toList();
    }

    public List<TrabajadorRequest> generateTrabajador(int cont) {
        return IntStream.range(0, cont).mapToObj(i -> {
            var faker = new Faker();
            var name = faker.name().firstName();
            var ci = faker.idNumber().valid();
            var direccion = generateDireccion(2);
            return new TrabajadorRequest(name, ci, direccion);
        }).toList();
    }

    public List<TrabajadorDocenteRequest> generateTrabajadorDocente(int cont) {
        return IntStream.range(0, cont).mapToObj(i -> {
            var faker = new Faker();
            var name = faker.name().firstName();
            var ci = faker.idNumber().valid();
            var grado = faker.educator().course();
            var categoriaCientifica = faker.educator().university();
            var direccion = generateDireccion(2);
            return new TrabajadorDocenteRequest(name, ci, direccion, grado, categoriaCientifica);
        }).toList();
    }

    public List<TrabajadorNoDocenteRequest> generateTrabajadorNoDocente(int cont) {
        return IntStream.range(0, cont).mapToObj(i -> {
            var faker = new Faker();
            var name = faker.name().firstName();
            var ci = faker.idNumber().valid();
            var cargo = faker.job().position();
            var categoria = faker.job().field();
            var direccion = generateDireccion(2);
            return new TrabajadorNoDocenteRequest(name, ci, direccion, cargo, categoria);
        }).toList();
    }

    public List<DireccionRequest> generateDireccion(int cont) {
        return IntStream.range(0, cont).mapToObj(i -> {
            var faker = new Faker();
            var direccion = faker.address();
            return new DireccionRequest(
                    direccion.state(),
                    direccion.city(),
                    direccion.streetName(),
                    direccion.buildingNumber()
            );
        }).toList();
    }

    @Override
    public void run() {
        try {
            log.info("Generando datos");
            var users = generateUsers(10);
            var trabajadores = generateTrabajador(10);
            var trabajadoresDocentes = generateTrabajadorDocente(10);
            var trabajadoresNoDocentes = generateTrabajadorNoDocente(10);

            users.forEach(authService::createUser);
            authService.createUser(new LoginRequest("adrewdev", "pass"));
            trabajadores.forEach(authService::registerUser);
            trabajadoresDocentes.forEach(authService::registerUser);
            trabajadoresNoDocentes.forEach(authService::registerUser);
        } catch (Exception e) {
            log.error("Error al registrar usuario", e);
            throw new RuntimeException(e);
        }
    }
}
