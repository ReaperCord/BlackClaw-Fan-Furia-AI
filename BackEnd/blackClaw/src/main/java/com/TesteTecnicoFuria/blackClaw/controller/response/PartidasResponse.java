package com.TesteTecnicoFuria.blackClaw.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Builder
public record PartidasResponse(Long id,
                               String adversario,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                               LocalDateTime dataPartida,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
                               LocalTime duracaoPartida,
                               List<Long> eventosId,
                               List<Long> mapasId) {
}
