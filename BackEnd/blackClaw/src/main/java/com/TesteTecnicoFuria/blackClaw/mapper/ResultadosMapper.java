package com.TesteTecnicoFuria.blackClaw.mapper;

import com.TesteTecnicoFuria.blackClaw.Entity.Jogadores;
import com.TesteTecnicoFuria.blackClaw.Entity.Mapas;
import com.TesteTecnicoFuria.blackClaw.Entity.Resultados;
import com.TesteTecnicoFuria.blackClaw.controller.request.ResultadosRequest;
import com.TesteTecnicoFuria.blackClaw.controller.response.JogadoresResponse;
import com.TesteTecnicoFuria.blackClaw.controller.response.MapasResponse;
import com.TesteTecnicoFuria.blackClaw.controller.response.ResultadosResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ResultadosMapper {

    public static Resultados toResultados(ResultadosRequest resultadosRequest) {

        // Mapeando jogadores
        List<Jogadores> jogadores = resultadosRequest.jogadorId().stream()
                .map(jogadorId -> Jogadores.builder().id(jogadorId).build())
                .toList();

        // Mapeando mapas
        List<Mapas> mapas = resultadosRequest.mapaId().stream()
                .map(mapaId -> Mapas.builder().id(mapaId).build())
                .toList();

        return Resultados.builder()
                .abates(resultadosRequest.abates())
                .mortes(resultadosRequest.mortes())
                .diferenca(resultadosRequest.diferenca())
                .adr(resultadosRequest.adr())
                .kast(resultadosRequest.kast())
                .rating(resultadosRequest.rating())
                .jogador(jogadores)
                .mapa(mapas.isEmpty() ? null : mapas.get(0)) // Se não houver mapas, não atribui nada
                .build();
    }

    public static ResultadosResponse toResultadosResponse(Resultados resultados) {

        // Converte a lista de jogadores em uma lista de IDs
        List<Long> jogadorIds = resultados.getJogador().stream()
                .map(Jogadores::getId)
                .collect(Collectors.toList());

        // Converte o mapa (único) para ID, se existir
        Long mapaId = resultados.getMapa() != null ? resultados.getMapa().getId() : null;

        return ResultadosResponse.builder()
                .id(resultados.getId())
                .abates(resultados.getAbates())
                .mortes(resultados.getMortes())
                .diferenca(resultados.getDiferenca())
                .adr(resultados.getAdr())
                .kast(resultados.getKast())
                .rating(resultados.getRating())
                .jogadorId(jogadorIds)
                .mapaId(mapaId)
                .build();
    }
}

