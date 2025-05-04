package com.TesteTecnicoFuria.blackClaw.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proximos_jogos")
@Getter
@Setter
public class ProximosJogos {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "eventos_id")
    private Eventos evento;

    @Column(name = "adversario")
    private String adversario;

    @Column(name = "data")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDate dataJogo;


}
