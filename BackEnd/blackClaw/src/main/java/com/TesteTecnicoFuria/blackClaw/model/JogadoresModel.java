package com.TesteTecnicoFuria.blackClaw.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "jogadores")
@NoArgsConstructor
@AllArgsConstructor
public class JogadoresModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "nacionalidade")
    private String nacionalidade;

    @Column(name = "funcao_ingame")
    @Enumerated(EnumType.STRING)
    private FuncaoInGame funcoesInGame;

    @Column(name = "tipo_contrato")
    @Enumerated(EnumType.STRING)
    private TipoContrato tipoDeContrato;

    @Column(name = "data_de_entrada")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataDeEntrada;

    @Column(name = "data_de_saida")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataDeSaida;

    @Column(name = "duracao_contrato")
    private String DuracaoContrato;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public FuncaoInGame getFuncoesInGame() {
        return funcoesInGame;
    }

    public void setFuncoesInGame(FuncaoInGame funcoesInGame) {
        this.funcoesInGame = funcoesInGame;
    }

    public TipoContrato getTipoDeContrato() {
        return tipoDeContrato;
    }

    public void setTipoDeContrato(TipoContrato tipoDeContrato) {
        this.tipoDeContrato = tipoDeContrato;
    }

    public Date getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(Date dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public Date getDataDeSaida() {
        return dataDeSaida;
    }

    public void setDataDeSaida(Date dataDeSaida) {
        this.dataDeSaida = dataDeSaida;
    }

    public String getDuracaoContrato() {
        return DuracaoContrato;
    }

    public void setDuracaoContrato(String duracaoContrato) {
        DuracaoContrato = duracaoContrato;
    }
}
