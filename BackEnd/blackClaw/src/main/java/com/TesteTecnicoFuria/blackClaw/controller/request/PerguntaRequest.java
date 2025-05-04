package com.TesteTecnicoFuria.blackClaw.controller.request;

import com.TesteTecnicoFuria.blackClaw.Entity.*;

import java.util.List;

public record PerguntaRequest(
        List<Eventos> eventos,
        List<Faq> faq,
        List<Jogadores> jogadores,
        List<Mapas> mapas,
        List<Partidas> partidas,
        List<ProximosJogos> proximosJogos,
        List<Resultados> resultados,
        String perguntaDoUsuario) {}

