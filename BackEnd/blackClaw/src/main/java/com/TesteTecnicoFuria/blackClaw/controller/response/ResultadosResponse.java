package com.TesteTecnicoFuria.blackClaw.controller.response;

import com.TesteTecnicoFuria.blackClaw.Entity.Jogadores;
import com.TesteTecnicoFuria.blackClaw.Entity.Mapas;
import lombok.Builder;

import java.util.List;

@Builder
public record ResultadosResponse(Long id,
                                 Integer abates,
                                 Integer mortes,
                                 Integer diferenca,
                                 Double adr,
                                 Double kast,
                                 Double rating,
                                 List<Long> jogadorId,
                                 Long mapaId) {
}
