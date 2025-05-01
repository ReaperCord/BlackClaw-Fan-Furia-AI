package com.TesteTecnicoFuria.blackClaw.mapper;

import com.TesteTecnicoFuria.blackClaw.Entity.Partidas;
import com.TesteTecnicoFuria.blackClaw.controller.request.PartidasRequest;
import com.TesteTecnicoFuria.blackClaw.controller.response.PartidasResponse;

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
                .build();
    }
}
