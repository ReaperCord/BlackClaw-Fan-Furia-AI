package com.TesteTecnicoFuria.blackClaw.controller.response;

import com.TesteTecnicoFuria.blackClaw.Entity.Partidas;
import lombok.Builder;

import java.util.List;

@Builder
public record MapasResponse(Long id,
                            List<Long> partidasId,
                            String nomeMapa) {
}
