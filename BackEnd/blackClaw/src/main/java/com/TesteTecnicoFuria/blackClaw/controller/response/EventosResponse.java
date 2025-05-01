package com.TesteTecnicoFuria.blackClaw.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EventosResponse(Long id,
                              String nome,
                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                              LocalDateTime dataDeInicio,
                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                              LocalDateTime dataDeTermino) {
}
