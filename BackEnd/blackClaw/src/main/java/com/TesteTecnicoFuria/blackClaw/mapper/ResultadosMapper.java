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

        // Mapeando jogador
        List<JogadoresResponse> jogadoresResponse = resultados.getJogador().stream()
                .map(JogadoresMapper::toJogadorResponse)  // Mapeia cada jogador para JogadoresResponse
                .collect(Collectors.toList());

        // Mapeando mapa
        MapasResponse mapaResponse = MapasMapper.mapasResponse(resultados.getMapa());

        // Retornando a resposta
        return ResultadosResponse.builder()
                .id(resultados.getId())
                .abates(resultados.getAbates())
                .mortes(resultados.getMortes())
                .diferenca(resultados.getDiferenca())
                .adr(resultados.getAdr())
                .kast(resultados.getKast())
                .rating(resultados.getRating())
                .jogadorId(jogadoresResponse)
                .mapaId(mapaResponse.id())
                .build();
    }
}

