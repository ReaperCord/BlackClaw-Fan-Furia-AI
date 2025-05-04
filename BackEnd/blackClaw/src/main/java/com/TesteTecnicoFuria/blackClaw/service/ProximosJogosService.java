package com.TesteTecnicoFuria.blackClaw.service;

import com.TesteTecnicoFuria.blackClaw.Entity.Eventos;
import com.TesteTecnicoFuria.blackClaw.Entity.ProximosJogos;
import com.TesteTecnicoFuria.blackClaw.repository.ProximosJogosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProximosJogosService {

    private final ProximosJogosRepository proximosJogosRepository;
    private final EventosService eventosService;

    public List<ProximosJogos> findAll() {
        return proximosJogosRepository.findAll();
    }

    public Optional<ProximosJogos> findById(Long id) {
        return proximosJogosRepository.findById(id);
    }

    public void deleteById(Long id) {
        proximosJogosRepository.deleteById(id);
    }
}
