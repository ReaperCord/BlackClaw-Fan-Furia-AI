package com.TesteTecnicoFuria.blackClaw.controller.response;

import lombok.Builder;

import java.util.List;

@Builder
public record MapasResponse(Long id,
                            List<Long> partidasId,
                            String nomeMapa) {
}
