package com.TesteTecnicoFuria.blackClaw.service;

import com.TesteTecnicoFuria.blackClaw.Entity.Mapas;
import com.TesteTecnicoFuria.blackClaw.Entity.Partidas;
import com.TesteTecnicoFuria.blackClaw.repository.MapaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MapasService {

    private final MapaRepository mapaRepository;
    private final PartidasService partidasService;


    public List<Mapas> findAll() {
        return mapaRepository.findAll();
    }

    public Optional<Mapas> findById(Long id) {
        return mapaRepository.findById(id);
    }

    public void delete(Mapas mapa) {
        mapaRepository.delete(mapa);
    }
}
