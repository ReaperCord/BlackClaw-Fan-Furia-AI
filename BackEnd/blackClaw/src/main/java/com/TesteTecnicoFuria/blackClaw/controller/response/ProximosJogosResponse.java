package com.TesteTecnicoFuria.blackClaw.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ProximosJogosResponse(Long id,
                                    List<Long> eventosId,
                                    String adversario,
                                    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                                    LocalDateTime dataJogo) {
}
