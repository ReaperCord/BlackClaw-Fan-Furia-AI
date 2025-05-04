package com.TesteTecnicoFuria.blackClaw.controller.response;

import com.TesteTecnicoFuria.blackClaw.Entity.Eventos;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ProximosJogosResponse(Long id,
                                    Eventos eventosId,
                                    String adversario,
                                    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                                    LocalDateTime dataJogo) {
}
