package com.TesteTecnicoFuria.blackClaw.controller;

import com.TesteTecnicoFuria.blackClaw.controller.response.ResultadosResponse;
import com.TesteTecnicoFuria.blackClaw.service.ResultadosService;
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
@RequestMapping("/contexto/resultados")
@RequiredArgsConstructor
public class ResultadosController {

    private final ResultadosService resultadosService;

    @GetMapping
    @Operation(summary = "Listar resultados", description = "Lista todos os resultados cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resultados encontrados"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            @ApiResponse(responseCode = "404", description = "Nenhum resultado encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<ResultadosResponse>> findAll() {
        List<ResultadosResponse> resultadosResponse = resultadosService.findAll()
                .stream()
                .map(resultado -> new ResultadosResponse(
                        resultado.getId(),
                        resultado.getAbates(),
                        resultado.getMortes(),
                        resultado.getDiferenca(),
                        resultado.getAdr(),
                        resultado.getKast(),
                        resultado.getRating(),
                        resultado.getJogador().stream().map(jogador -> jogador.getId()).toList(),
                        resultado.getMapa() != null ? resultado.getMapa().getId() : null
                ))
                .toList();

        return ResponseEntity.ok(resultadosResponse);
    }
}
