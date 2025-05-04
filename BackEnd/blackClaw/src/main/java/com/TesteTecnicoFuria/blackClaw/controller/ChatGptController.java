package com.TesteTecnicoFuria.blackClaw.controller;

import com.TesteTecnicoFuria.blackClaw.Entity.*;
import com.TesteTecnicoFuria.blackClaw.repository.*;
import com.TesteTecnicoFuria.blackClaw.service.ChatGptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;


@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatGptController {

    private final ChatGptService chatGptService;
    private final EventosRepository eventosRepository;
    private final FaqRepository faqRepository;
    private final JogadoresRepository jogadoresRepository;
    private final MapaRepository mapasRepository;
    private final PartidasRepository partidasRepository;
    private final ProximosJogosRepository proximosJogosRepository;
    private final ResultadosRepository resultadosRepository;

    @PostMapping("/pergunta")
    public Mono<ResponseEntity<String>> fazerPergunta(@RequestBody String perguntaDoUsuario) {
        // Validação básica da entrada
        if (perguntaDoUsuario == null || perguntaDoUsuario.trim().isEmpty()) {
            return Mono.just(ResponseEntity
                    .badRequest()
                    .body("A pergunta não pode ser vazia"));
        }

        try {
            // Busca otimizada dos dados (paralelismo)
            Mono<List<Eventos>> eventosMono = Mono.fromCallable(eventosRepository::findAll);
            Mono<List<Faq>> faqMono = Mono.fromCallable(faqRepository::findAll);
            Mono<List<Jogadores>> jogadoresMono = Mono.fromCallable(jogadoresRepository::findAll);
            Mono<List<Mapas>> mapasMono = Mono.fromCallable(mapasRepository::findAll);
            Mono<List<Partidas>> partidasMono = Mono.fromCallable(partidasRepository::findAll);
            Mono<List<ProximosJogos>> proximosJogosMono = Mono.fromCallable(proximosJogosRepository::findAll);
            Mono<List<Resultados>> resultadosMono = Mono.fromCallable(resultadosRepository::findAll);

            return Mono.zip(eventosMono, faqMono, jogadoresMono, mapasMono,
                            partidasMono, proximosJogosMono, resultadosMono)
                    .flatMap(tuple -> {
                        List<Eventos> eventos = tuple.getT1();
                        List<Faq> faq = tuple.getT2();
                        List<Jogadores> jogadores = tuple.getT3();
                        List<Mapas> mapas = tuple.getT4();
                        List<Partidas> partidas = tuple.getT5();
                        List<ProximosJogos> proximosJogos = tuple.getT6();
                        List<Resultados> resultados = tuple.getT7();

                        return chatGptService.gerarPergunta(
                                eventos,
                                faq,
                                jogadores,
                                mapas,
                                partidas,
                                proximosJogos,
                                resultados,
                                perguntaDoUsuario
                        );
                    })
                    .map(response -> ResponseEntity.ok().body(response))
                    .timeout(Duration.ofSeconds(30)) // Timeout de 30 segundos
                    .onErrorResume(e -> {
                        if (e instanceof TimeoutException) {
                            return Mono.just(ResponseEntity
                                    .status(HttpStatus.REQUEST_TIMEOUT)
                                    .body("Tempo limite excedido ao processar sua pergunta"));
                        }
                        e.printStackTrace();
                        return Mono.just(ResponseEntity
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Erro ao processar sua pergunta: " + e.getMessage()));
                    });
        } catch (Exception e) {
            e.printStackTrace();
            return Mono.just(ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro inesperado ao processar sua pergunta"));
        }
    }
}