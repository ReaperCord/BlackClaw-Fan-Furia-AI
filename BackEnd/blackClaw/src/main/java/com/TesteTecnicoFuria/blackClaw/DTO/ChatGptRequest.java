package com.TesteTecnicoFuria.blackClaw.DTO;

import com.TesteTecnicoFuria.blackClaw.Entity.*;
import java.util.List;

public class ChatGptRequest {

    private List<Eventos> eventos;
    private List<Faq> faq;
    private List<Jogadores> jogadores;
    private List<Mapas> mapas;
    private List<Partidas> partidas;
    private List<ProximosJogos> proximosJogos;
    private List<Resultados> resultados;
    private String perguntaUsuario;

    // Getters e Setters
    public List<Eventos> getEventos() { return eventos; }
    public void setEventos(List<Eventos> eventos) { this.eventos = eventos; }

    public List<Faq> getFaq() { return faq; }
    public void setFaq(List<Faq> faq) { this.faq = faq; }

    public List<Jogadores> getJogadores() { return jogadores; }
    public void setJogadores(List<Jogadores> jogadores) { this.jogadores = jogadores; }

    public List<Mapas> getMapas() { return mapas; }
    public void setMapas(List<Mapas> mapas) { this.mapas = mapas; }

    public List<Partidas> getPartidas() { return partidas; }
    public void setPartidas(List<Partidas> partidas) { this.partidas = partidas; }

    public List<ProximosJogos> getProximosJogos() { return proximosJogos; }
    public void setProximosJogos(List<ProximosJogos> proximosJogos) { this.proximosJogos = proximosJogos; }

    public List<Resultados> getResultados() { return resultados; }
    public void setResultados(List<Resultados> resultados) { this.resultados = resultados; }

    public String getPerguntaUsuario() { return perguntaUsuario; }
    public void setPerguntaUsuario(String perguntaUsuario) { this.perguntaUsuario = perguntaUsuario; }
}

