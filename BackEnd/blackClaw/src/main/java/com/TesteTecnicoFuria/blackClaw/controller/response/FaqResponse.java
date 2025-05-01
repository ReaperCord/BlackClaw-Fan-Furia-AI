package com.TesteTecnicoFuria.blackClaw.controller.response;

import lombok.Builder;

@Builder
public record FaqResponse(Long id,
                          String pergunta,
                          String resposta) {
}
