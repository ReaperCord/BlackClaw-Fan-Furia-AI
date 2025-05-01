package com.TesteTecnicoFuria.blackClaw.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record ProximosJogosRequest(List<Long> eventosId,
                                   String adversario,
                                   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                                   LocalDateTime dataJogo) {
}
