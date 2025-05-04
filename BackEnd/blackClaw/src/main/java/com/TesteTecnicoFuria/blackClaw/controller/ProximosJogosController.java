package com.TesteTecnicoFuria.blackClaw.controller;

import com.TesteTecnicoFuria.blackClaw.Entity.ProximosJogos;
import com.TesteTecnicoFuria.blackClaw.controller.response.ProximosJogosResponse;
import com.TesteTecnicoFuria.blackClaw.service.ProximosJogosService;
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
@RequestMapping("/contexto/proximosjogos")
@RequiredArgsConstructor
public class ProximosJogosController {

    private final ProximosJogosService proximosJogosService;

    @GetMapping
    @Operation(summary = "Listar próximos jogos", description = "Lista todos os próximos jogos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Próximos jogos encontrados"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            @ApiResponse(responseCode = "404", description = "Nenhum próximo jogo encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<ProximosJogosResponse>> findAll() {
        List<ProximosJogosResponse> proximosJogosResponse = proximosJogosService.findAll()
                .stream()
                .map(pJogos -> new ProximosJogosResponse(
                        pJogos.getId(),
                        pJogos.getEvento(),
                        pJogos.getAdversario(),
                        pJogos.getDataJogo().atStartOfDay()
                ))
                .toList();

        return ResponseEntity.ok(proximosJogosResponse);
    }
}
