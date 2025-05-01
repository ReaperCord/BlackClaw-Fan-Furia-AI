package com.TesteTecnicoFuria.blackClaw.mapper;

import com.TesteTecnicoFuria.blackClaw.Entity.ProximosJogos;
import com.TesteTecnicoFuria.blackClaw.controller.request.ProximosJogosRequest;
import com.TesteTecnicoFuria.blackClaw.controller.response.ProximosJogosResponse;

public class ProximosJogosMapper {

    public static ProximosJogos proximosJogos(ProximosJogosRequest proximosJogosRequest) {
        return ProximosJogos.builder()
                .adversario(proximosJogosRequest.adversario())
                .dataJogo(proximosJogosRequest.dataJogo().toLocalDate())
                .build();
    }

    public static ProximosJogosResponse proximosJogosResponse(ProximosJogos proximosJogos) {
        return ProximosJogosResponse.builder()
                .id(proximosJogos.getId())
                .adversario(proximosJogos.getAdversario())
                .dataJogo(proximosJogos.getDataJogo().atStartOfDay())
                .build();
    }
}
