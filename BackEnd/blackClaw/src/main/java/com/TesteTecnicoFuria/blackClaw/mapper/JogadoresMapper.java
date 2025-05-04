package com.TesteTecnicoFuria.blackClaw.mapper;

import com.TesteTecnicoFuria.blackClaw.Entity.FuncaoInGame;
import com.TesteTecnicoFuria.blackClaw.Entity.TipoContrato;
import com.TesteTecnicoFuria.blackClaw.controller.request.JogadoresRequest;
import com.TesteTecnicoFuria.blackClaw.Entity.Jogadores;
import com.TesteTecnicoFuria.blackClaw.controller.response.JogadoresResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class JogadoresMapper {

    public static Jogadores toJogador(JogadoresRequest jogadoresRequest) {
        return Jogadores.builder()
                .nome(jogadoresRequest.nome())
                .nickname(jogadoresRequest.nickname())
                .funcoesInGame(FuncaoInGame.valueOf(jogadoresRequest.funcoesInGame()))  // Conversão de String para Enum
                .idade(jogadoresRequest.idade())
                .nacionalidade(jogadoresRequest.nacionalidade())
                .tipoDeContrato(TipoContrato.valueOf(jogadoresRequest.tipoDeContrato()))  // Conversão de String para Enum
                .duracaoContrato(jogadoresRequest.duracaoContrato())
                .dataDeEntrada(jogadoresRequest.dataDeEntrada().toLocalDate())
                .dataDeSaida(jogadoresRequest.dataDeSaida().toLocalDate())
                .build();
    }

    public static JogadoresResponse toJogadorResponse(Jogadores jogadores) {
        return JogadoresResponse.builder()
                .id(jogadores.getId())
                .nome(jogadores.getNome())
                .nickname(jogadores.getNickname())
                .idade(jogadores.getIdade())
                .funcoesInGame(jogadores.getFuncoesInGame())
                .dataDeEntrada(jogadores.getDataDeEntrada().atStartOfDay())
                .dataDeSaida(jogadores.getDataDeSaida().atStartOfDay())
                .nacionalidade(jogadores.getNacionalidade())
                .duracaoContrato(jogadores.getDuracaoContrato())
                .tipoDeContrato(jogadores.getTipoDeContrato())
                .build();
    }

    public static JogadoresResponse jogadoresResponse(Jogadores jogadores) {
        return JogadoresResponse.builder()
                .id(jogadores.getId())
                .nome(jogadores.getNome())
                .nickname(jogadores.getNickname())
                .idade(jogadores.getIdade())
                .funcoesInGame(jogadores.getFuncoesInGame())
                .dataDeEntrada(jogadores.getDataDeEntrada().atStartOfDay())
                .dataDeSaida(jogadores.getDataDeSaida().atStartOfDay())
                .nacionalidade(jogadores.getNacionalidade())
                .duracaoContrato(jogadores.getDuracaoContrato())
                .tipoDeContrato(jogadores.getTipoDeContrato())
                .build();
    }
}

