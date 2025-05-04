package com.TesteTecnicoFuria.blackClaw.controller;


import com.TesteTecnicoFuria.blackClaw.controller.response.FaqResponse;
import com.TesteTecnicoFuria.blackClaw.controller.response.PartidasResponse;
import com.TesteTecnicoFuria.blackClaw.repository.PartidasRepository;
import com.TesteTecnicoFuria.blackClaw.service.FaqService;
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
@RequestMapping("/contexto/faq")
@RequiredArgsConstructor
public class FaqController {

    private final FaqService faqService;

    @GetMapping
    @Operation(summary = "Listar FAQ", description = "Lista todas as perguntas frequentes cadastradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "FAQ encontrada"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            @ApiResponse(responseCode = "404", description = "Nenhum FAQ encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<FaqResponse>> findAll() {
        List<FaqResponse> faqResponse = faqService.findAll()
                .stream()
                .map(faq -> new FaqResponse(faq.getId(), faq.getResposta(), faq.getPergunta()))
                .toList();

        return ResponseEntity.ok(faqResponse);
    }
}
