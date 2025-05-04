package com.TesteTecnicoFuria.blackClaw.controller;

import com.TesteTecnicoFuria.blackClaw.controller.response.MapasResponse;
import com.TesteTecnicoFuria.blackClaw.mapper.MapasMapper;
import com.TesteTecnicoFuria.blackClaw.service.MapasService;
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
@RequestMapping("/contexto/mapas")
@RequiredArgsConstructor
public class MapasController {

    private final MapasService mapasService;

    @GetMapping
    @Operation(summary = "Listar mapas", description = "Lista todos os mapas cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mapas encontrados"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            @ApiResponse(responseCode = "404", description = "Nenhum mapa encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<MapasResponse>> findAll(){
        List<MapasResponse> mapasResposnse = mapasService.findAll()
                .stream()
                .map(MapasMapper::mapasResponse)
                .toList();

        return ResponseEntity.ok(mapasResposnse);
    }
}
