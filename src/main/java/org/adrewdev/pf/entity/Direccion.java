package org.adrewdev.pf.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String provincia;
    private String municipio;
    private String calle;
    private String numero;
    @ManyToOne
    @JoinColumn(name = "trabajador_id")
    private Trabajador trabajador;

    public Direccion(String provincia, String municipio, String calle, String numero) {
        this.provincia = provincia;
        this.municipio = municipio;
        this.calle = calle;
        this.numero = numero;
    }
}