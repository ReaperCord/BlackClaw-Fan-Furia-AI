package com.TesteTecnicoFuria.blackClaw.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "partidas")
@NoArgsConstructor
@AllArgsConstructor
public class PartidasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "eventos_id")
    private EventosModel evento;

    @Column(name = "adversario")
    private String adversario;

    @Column(name = "data")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime dataPartida;

    @Column(name = "tempo_geral_partida")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalTime duracaoPartida;

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventosModel getEvento() {
        return evento;
    }

    public void setEvento(EventosModel evento) {
        this.evento = evento;
    }

    public String getAdversario() {
        return adversario;
    }

    public void setAdversario(String adversario) {
        this.adversario = adversario;
    }

    public LocalDateTime getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(LocalDateTime dataPartida) {
        this.dataPartida = dataPartida;
    }

    public LocalTime getDuracaoPartida() {
        return duracaoPartida;
    }

    public void setDuracaoPartida(LocalTime duracaoPartida) {
        this.duracaoPartida = duracaoPartida;
    }
}
