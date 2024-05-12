package org.adrewdev.pf.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String carneIdentidad;
    @OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Direccion> direcciones;
    public Trabajador(String nombre , String carneIdentidad){
        this.nombre = nombre;
        this.carneIdentidad = carneIdentidad;
    }
}
