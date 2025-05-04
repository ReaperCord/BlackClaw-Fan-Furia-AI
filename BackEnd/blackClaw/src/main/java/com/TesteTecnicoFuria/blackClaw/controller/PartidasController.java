package com.TesteTecnicoFuria.blackClaw.controller;

import com.TesteTecnicoFuria.blackClaw.controller.response.PartidasResponse;
import com.TesteTecnicoFuria.blackClaw.mapper.PartidasMapper;
import com.TesteTecnicoFuria.blackClaw.repository.PartidasRepository;
import com.TesteTecnicoFuria.blackClaw.service.PartidasService;
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
@RequestMapping("/contexto/partidas")
@RequiredArgsConstructor
public class PartidasController {

    protected final PartidasRepository partidasRepository;
    private final PartidasService partidasService;

    @GetMapping
    @Operation(summary = "Listar Partidas", description = "Lista todas as partidas cadastradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Partidas encontrada"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            @ApiResponse(responseCode = "404", description = "Nenhuma partida encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<PartidasResponse>> findAll() {
        List<PartidasResponse> partidasResponse = partidasService.findAll()
                .stream()
                .map(PartidasMapper::partidasResponse)
                .toList();

        return ResponseEntity.ok(partidasResponse);
    }
}
