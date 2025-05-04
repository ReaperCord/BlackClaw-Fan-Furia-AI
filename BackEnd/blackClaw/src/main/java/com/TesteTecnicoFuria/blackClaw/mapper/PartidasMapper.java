package com.TesteTecnicoFuria.blackClaw.mapper;

import com.TesteTecnicoFuria.blackClaw.Entity.Partidas;
import com.TesteTecnicoFuria.blackClaw.controller.request.PartidasRequest;
import com.TesteTecnicoFuria.blackClaw.controller.response.PartidasResponse;

import java.util.List;

public class PartidasMapper {

    public static Partidas partidas(PartidasRequest partidasRequest) {
        return Partidas.builder()
                .adversario(partidasRequest.adversario())
                .dataPartida(partidasRequest.dataPartida())
                .duracaoPartidaHH(partidasRequest.duracaoPartida())
                .build();
    }

    public static PartidasResponse partidasResponse(Partidas partidas) {
        return PartidasResponse.builder()
                .id(partidas.getId())
                .adversario(partidas.getAdversario())
                .dataPartida(partidas.getDataPartida())
                .duracaoPartida(partidas.getDuracaoPartidaHH())
                .eventosId(partidas.getEvento() != null ?
                        List.of(partidas.getEvento().getId()) :
                        null)
                .mapasId(partidas.getMapas() != null ?
                        partidas.getMapas().stream().map(mapa -> mapa.getId()).toList() :
                        null)
                .build();
    }
}
