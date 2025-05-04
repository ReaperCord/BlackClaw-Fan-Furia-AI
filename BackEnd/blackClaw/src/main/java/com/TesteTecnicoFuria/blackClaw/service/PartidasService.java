package com.TesteTecnicoFuria.blackClaw.service;

import com.TesteTecnicoFuria.blackClaw.Entity.Eventos;
import com.TesteTecnicoFuria.blackClaw.Entity.Partidas;
import com.TesteTecnicoFuria.blackClaw.repository.PartidasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartidasService {

    private final PartidasRepository partidasRepository;
    private final EventosService eventosService;

    public List<Partidas> findAll() {
        return partidasRepository.findAll();
    }

    public Optional<Partidas> findById(Long id) {
        return partidasRepository.findById(id);
    }

    public void delete(Long id) {
        partidasRepository.deleteById(id);
    }
}
