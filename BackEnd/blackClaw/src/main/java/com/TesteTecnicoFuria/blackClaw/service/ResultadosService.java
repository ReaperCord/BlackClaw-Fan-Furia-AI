package com.TesteTecnicoFuria.blackClaw.service;

import com.TesteTecnicoFuria.blackClaw.Entity.Resultados;
import com.TesteTecnicoFuria.blackClaw.repository.ResultadosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResultadosService {

    private final ResultadosRepository resultadosRepository;

    public List<Resultados> findAll() {
        return resultadosRepository.findAll();
    }

    public Optional<Resultados> findById(Long id) {
        return resultadosRepository.findById(id);
    }

    public void delete(Long id) {
        resultadosRepository.deleteById(id);
    }

}
