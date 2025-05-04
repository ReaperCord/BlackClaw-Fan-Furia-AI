package com.TesteTecnicoFuria.blackClaw.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Builder
@Entity
@Table(name = "jogadores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Jogadores {

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

    @CreationTimestamp
    @Column(name = "data_de_entrada")
    private LocalDate dataDeEntrada;

    @UpdateTimestamp
    @Column(name = "data_de_saida")
    private LocalDate dataDeSaida;

    @Column(name = "duracao_contrato")
    private String duracaoContrato;
}
