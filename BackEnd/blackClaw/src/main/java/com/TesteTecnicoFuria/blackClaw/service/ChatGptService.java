package com.TesteTecnicoFuria.blackClaw.service;

import com.TesteTecnicoFuria.blackClaw.Entity.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChatGptService {

    private final WebClient webClient;
    private final String apiKey = System.getenv("CHATGPT_API_KEY");

    public ChatGptService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> gerarPergunta(List<Eventos> eventos,
                                      List<Faq> faq,
                                      List<Jogadores> jogadores,
                                      List<Mapas> mapas,
                                      List<Partidas> partidas,
                                      List<ProximosJogos> proximosJogos,
                                      List<Resultados> resultados,
                                      String perguntaUsuario) {
        String eventosStream = eventos.stream()
                .map(e -> String.format("Nome: %s, Data de Início: %s, Data de Término: %s",
                             e.getNome(), e.getDataDeInicio(), e.getDataDeTermino()))
                .collect(Collectors.joining("\n"));

        String faqStream = faq.stream()
                .map(f -> String.format("Pergunta: %s, Resposta: %s",
                        f.getPergunta(), f.getResposta()))
                .collect(Collectors.joining("\n"));

        String jogadoresStream = jogadores.stream()
                .map(j -> String.format("Nome: %s, Idade: %d, Posição: %s, Status: %s",
                        j.getNome(), j.getIdade(), j.getFuncoesInGame(), j.getTipoDeContrato()))
                .collect(Collectors.joining("\n"));

        String mapasStream = mapas.stream()
                .map(m -> String.format("Partida: %s, Nome do Mapa: %s",
                        m.getNomeMapa(), m.getPartida()))
                .collect(Collectors.joining("\n"));

        String partidasStream = partidas.stream()
                .map(p -> String.format("Evento: %s, Adversário: %s, Data: %s, Duração: %s",
                        p.getEvento(), p.getAdversario(), p.getDataPartida(), p.getDuracaoPartidaHH()))
                .collect(Collectors.joining("\n"));

        String proximosJogosStream = proximosJogos.stream()
                .map(pj -> String.format("Evento: %s, Adversário: %s, Data: %s",
                        pj.getEvento(), pj.getAdversario(), pj.getDataJogo()))
                .collect(Collectors.joining("\n"));

        String resultadosStream = resultados.stream()
                .map(r -> String.format("Mapa: %s, Jogadores: %s, ADR: %.2f, KAST: %.2f, Rating: %.2f",
                        r.getMapa(), r.getJogador(), r.getAdr(), r.getKast(), r.getRating()))
                .collect(Collectors.joining("\n"));

        String perguntaUsuarioStream = String.format("Pergunta do usuário: %s", perguntaUsuario);

        String contexto = "Você é um assistente conversacional amigável e bem-informado, especializado em e-sports. " +
                "Seu papel é responder de forma clara, útil e simpática, sempre com base nas informações fornecidas no banco de dados. " +
                "Você fala como uma pessoa real: organiza bem as ideias, conecta frases com naturalidade e evita respostas robóticas ou secas. " +
                "Se a informação estiver disponível no banco de dados, explique com detalhes suficientes para ajudar o usuário, mantendo um tom descontraído e acessível. " +
                "Se a informação não estiver no banco de dados, avise com gentileza e ofereça ajuda com o que estiver ao seu alcance. " +
                "Lembre-se: você é como um narrador de bastidores do mundo dos e-sports, ajudando fãs a entender melhor tudo o que está rolando com os times, jogadores e eventos.";

// Verifique o valor das variáveis
        if (contexto == null) {
            throw new IllegalArgumentException("Contexto não pode ser nulo.");
        }

        String promptContexto = String.format(
                "Contexto Atual:\n\n" +
                        "Eventos Recentes:\n%s\n\n" +
                        "Perguntas Frequentes (FAQ):\n%s\n\n" +
                        "Jogadores em Atividade:\n%s\n\n" +
                        "Mapas Utilizados nas Partidas:\n%s\n\n" +
                        "Últimas Partidas Realizadas:\n%s\n\n" +
                        "Próximos Jogos a Serem Realizados:\n%s\n\n" +
                        "Resultados Recente das Partidas:\n%s\n\n" +
                        "Agora, sobre a sua pergunta:\n%s",  // <- aqui entra a pergunta do usuário
                eventosStream, faqStream, jogadoresStream, mapasStream,
                partidasStream, proximosJogosStream, resultadosStream, perguntaUsuarioStream
        );

        if (promptContexto == null) {
            throw new IllegalArgumentException("Prompt contexto não pode ser nulo.");
        }

        if (perguntaUsuario == null) {
            throw new IllegalArgumentException("Pergunta do usuário não pode ser nula.");
        }


        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(
                        Map.of("role", "system", "content", contexto),
                        Map.of("role", "user", "content", promptContexto),
                        Map.of("role", "user", "content", perguntaUsuario)
                )
        );

        return webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .doOnNext(response -> System.out.println("Resposta da API: " + response)) // Imprime a resposta
                .map(response -> {
                    var choices = (List<Map<String, Object>>) response.get("choices");
                    if (choices != null && !choices.isEmpty()) {
                        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
                        return message.get("content").toString();
                    }
                    return "Nenhuma receita foi gerada.";
                });
    }
}
