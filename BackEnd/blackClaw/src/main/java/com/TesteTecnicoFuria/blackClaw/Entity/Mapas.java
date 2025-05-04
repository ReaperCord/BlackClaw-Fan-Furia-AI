package com.TesteTecnicoFuria.blackClaw.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mapas")
@Getter
@Setter
public class Mapas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "partidas_id")
    private Partidas partida;

    @Column(name = "nome_mapa")
    private String nomeMapa;
}
