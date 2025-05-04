package com.TesteTecnicoFuria.blackClaw.controller;

import com.TesteTecnicoFuria.blackClaw.controller.response.EventosResponse;
import com.TesteTecnicoFuria.blackClaw.repository.EventosRepository;
import com.TesteTecnicoFuria.blackClaw.service.EventosService;
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
@RequestMapping("/contexto/eventos")
@RequiredArgsConstructor
public class EventosController {

    private final EventosRepository eventosRepository;
    private final EventosService eventosService;

    @GetMapping
    @Operation(summary = "Listar eventos", description = "Lista todos os eventos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eventos encontrados"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            @ApiResponse(responseCode = "404", description = "Nenhum evento encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<EventosResponse>> findAll() {
        List<EventosResponse> eventosResponse = eventosService.findAll()
                .stream()
                .map(evento -> new EventosResponse(evento.getId(), evento.getNome(), evento.getDataDeInicio().atStartOfDay(), evento.getDataDeTermino().atStartOfDay()))
                .toList();

        return ResponseEntity.ok(eventosResponse);
    }

}
