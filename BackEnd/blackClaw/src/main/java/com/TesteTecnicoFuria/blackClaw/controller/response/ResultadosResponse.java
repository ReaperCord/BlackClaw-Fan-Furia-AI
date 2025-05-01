package com.TesteTecnicoFuria.blackClaw.controller.response;

import lombok.Builder;

import java.util.List;

@Builder
public record ResultadosResponse(Long id,
                                 Long mapaId,
                                 List<JogadoresResponse> jogadorId,
                                 Integer abates,
                                 Integer mortes,
                                 Integer diferenca,
                                 Double adr,
                                 Double kast,
                                 Double rating) {
}
