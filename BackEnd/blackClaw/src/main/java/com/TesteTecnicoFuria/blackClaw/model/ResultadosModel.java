package com.TesteTecnicoFuria.blackClaw.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "resultados")
@NoArgsConstructor
@AllArgsConstructor
public class ResultadosModel {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mapa_id")
    private MapasModel mapa;

    @ManyToOne
    @JoinColumn(name = "jogador_id")
    private JogadoresModel jogador;

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


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MapasModel getMapa() {
        return mapa;
    }

    public void setMapa(MapasModel mapa) {
        this.mapa = mapa;
    }

    public JogadoresModel getJogador() {
        return jogador;
    }

    public void setJogador(JogadoresModel jogador) {
        this.jogador = jogador;
    }

    public Integer getAbates() {
        return abates;
    }

    public void setAbates(Integer abates) {
        this.abates = abates;
    }

    public Integer getMortes() {
        return mortes;
    }

    public void setMortes(Integer mortes) {
        this.mortes = mortes;
    }

    public Integer getDiferenca() {
        return diferenca;
    }

    public void setDiferenca(Integer diferenca) {
        this.diferenca = diferenca;
    }

    public Double getAdr() {
        return adr;
    }

    public void setAdr(Double adr) {
        this.adr = adr;
    }

    public Double getKast() {
        return kast;
    }

    public void setKast(Double kast) {
        this.kast = kast;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
