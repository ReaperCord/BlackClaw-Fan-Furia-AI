package com.TesteTecnicoFuria.blackClaw.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record JogadoresRequest(String nome,
                               String nickname,
                               String funcoesInGame,
                               Integer idade,
                               String time,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                               LocalDateTime dataDeEntrada,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                               LocalDateTime dataDeSaida,
                               String nacionalidade,
                               String duracaoContrato,
                               String tipoDeContrato) {
}
