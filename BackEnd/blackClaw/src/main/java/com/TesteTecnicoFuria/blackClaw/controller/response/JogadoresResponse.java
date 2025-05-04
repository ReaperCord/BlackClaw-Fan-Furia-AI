package com.TesteTecnicoFuria.blackClaw.controller.response;

import com.TesteTecnicoFuria.blackClaw.Entity.FuncaoInGame;
import com.TesteTecnicoFuria.blackClaw.Entity.TipoContrato;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record JogadoresResponse(Long id,
                                String nome,
                                String nickname,
                                Integer idade,
                                FuncaoInGame funcoesInGame,
                                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                                LocalDateTime dataDeEntrada,
                                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                                LocalDateTime dataDeSaida,
                                String nacionalidade,
                                String duracaoContrato,
                                TipoContrato tipoDeContrato) {
}
