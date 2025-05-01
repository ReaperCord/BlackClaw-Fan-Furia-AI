package com.TesteTecnicoFuria.blackClaw.mapper;

import com.TesteTecnicoFuria.blackClaw.Entity.Mapas;
import com.TesteTecnicoFuria.blackClaw.Entity.Partidas;
import com.TesteTecnicoFuria.blackClaw.controller.request.MapasRequest;
import com.TesteTecnicoFuria.blackClaw.controller.response.MapasResponse;

import java.util.List;


public class MapasMapper {

    public static Mapas mapas(MapasRequest mapasRequest) {
        return Mapas.builder()
                .nomeMapa(mapasRequest.nomeMapa())
                .partida(mapasRequest.partidasId() != null && !mapasRequest.partidasId().isEmpty()
                        ? Partidas.builder().id(mapasRequest.partidasId().get(0)).build()
                        : null)
                .build();
    }

    public static MapasResponse mapasResponse(Mapas mapas) {
        return MapasResponse.builder()
                .id(mapas.getId())
                .partidasId(mapas.getPartida() != null ? List.of(mapas.getPartida().getId()) : null)
                .nomeMapa(mapas.getNomeMapa())
                .build();
    }
}
