package com.TesteTecnicoFuria.blackClaw.mapper;

import com.TesteTecnicoFuria.blackClaw.Entity.Eventos;
import com.TesteTecnicoFuria.blackClaw.controller.request.EventosRequest;
import com.TesteTecnicoFuria.blackClaw.controller.response.EventosResponse;

public class EventosMapper {

    public static Eventos toEventos(EventosRequest eventosRequest) {
        return Eventos.builder()
                .nome(eventosRequest.nome())
                .dataDeInicio(eventosRequest.dataDeInicio().toLocalDate())
                .dataDeTermino(eventosRequest.dataDeTermino().toLocalDate())
                .build();
    }

    public static EventosResponse toEventosResponse(Eventos eventos) {
        return EventosResponse.builder()
                .id(eventos.getId())
                .nome(eventos.getNome())
                .dataDeInicio(eventos.getDataDeInicio().atStartOfDay())
                .dataDeTermino(eventos.getDataDeTermino().atStartOfDay())
                .build();
    }
}
