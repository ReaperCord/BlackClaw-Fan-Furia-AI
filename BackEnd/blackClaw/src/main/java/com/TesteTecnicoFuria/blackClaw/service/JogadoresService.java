package com.TesteTecnicoFuria.blackClaw.service;

import com.TesteTecnicoFuria.blackClaw.Entity.Jogadores;
import com.TesteTecnicoFuria.blackClaw.repository.JogadoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JogadoresService {

    private final JogadoresRepository jogadoresRepository;

    public Jogadores save(Jogadores jogadores) {
        return jogadoresRepository.save(jogadores);
    }

    public List<Jogadores> findAll() {
        return jogadoresRepository.findAll();
    }

    public Optional<Jogadores> findById(Long id) {
        return jogadoresRepository.findById(id);
    }

    public void deleteById(Long id) {
        jogadoresRepository.deleteById(id);
    }
}
