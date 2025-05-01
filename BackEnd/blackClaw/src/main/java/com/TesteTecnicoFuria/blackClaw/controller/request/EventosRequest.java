package com.TesteTecnicoFuria.blackClaw.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record EventosRequest(String nome,
                             @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                             LocalDateTime dataDeInicio,
                             @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                             LocalDateTime dataDeTermino) {

}
