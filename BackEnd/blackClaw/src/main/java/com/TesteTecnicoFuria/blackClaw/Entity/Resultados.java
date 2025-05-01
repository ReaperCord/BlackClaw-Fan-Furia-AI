package com.TesteTecnicoFuria.blackClaw.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@Table(name = "resultados")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Resultados {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mapa_id")
    private Mapas mapa;

    @ManyToMany
    @JoinTable(
            name = "resultado_jogadores",
            joinColumns = @JoinColumn(name = "resultado_id"),
            inverseJoinColumns = @JoinColumn(name = "jogador_id")
    )
    private List<Jogadores> jogador;

    @Column(name = "abates")
    private Integer abates;

    @Column(name = "mortes")
    private Integer mortes;

    @Column(name = "diferenca")
    private Integer diferenca;

    @Column(name = "adr")
    private Double adr;

    @Column(name = "kast")
    private Double kast;

    @Column(name = "rating")
    private Double rating;

}
