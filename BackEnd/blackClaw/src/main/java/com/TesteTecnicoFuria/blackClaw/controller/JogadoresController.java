package com.TesteTecnicoFuria.blackClaw.controller;

import com.TesteTecnicoFuria.blackClaw.controller.response.JogadoresResponse;
import com.TesteTecnicoFuria.blackClaw.repository.JogadoresRepository;
import com.TesteTecnicoFuria.blackClaw.service.JogadoresService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contexto/jogadores")
@RequiredArgsConstructor
public class JogadoresController {

    private final JogadoresService jogadoresService;
    private final JogadoresRepository jogadoresRepository;

    @GetMapping
    @Operation(summary = "Listar jogadores", description = "Lista todos os jogadores cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Jogadores encontrados"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            @ApiResponse(responseCode = "404", description = "Nenhum jogador encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<JogadoresResponse>> findAll() {
        List<JogadoresResponse> jogadoresResponse = jogadoresService.findAll()
                .stream()
                .map(jogador -> new JogadoresResponse(
                        jogador.getId(),
                        jogador.getNome(),
                        jogador.getNickname(),
                        jogador.getIdade(), // Idade primeiro
                        jogador.getFuncoesInGame(), // Depois função
                        jogador.getDataDeEntrada() != null ? jogador.getDataDeEntrada().atStartOfDay() : null,
                        jogador.getDataDeSaida() != null ? jogador.getDataDeSaida().atStartOfDay() : null,
                        jogador.getNacionalidade(),
                        jogador.getDuracaoContrato(),
                        jogador.getTipoDeContrato()
                ))
                .toList();

        return ResponseEntity.ok(jogadoresResponse);
    }
}
