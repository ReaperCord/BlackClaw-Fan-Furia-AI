package com.TesteTecnicoFuria.blackClaw.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public record PartidasRequest(String adversario,
                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                              LocalDateTime dataPartida,
                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
                              LocalTime duracaoPartida,
                              List<Long> eventosId,
                              List<Long> mapasId) {
}
