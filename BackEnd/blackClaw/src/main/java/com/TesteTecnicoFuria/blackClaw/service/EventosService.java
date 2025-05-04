package com.TesteTecnicoFuria.blackClaw.service;

import com.TesteTecnicoFuria.blackClaw.Entity.Eventos;
import com.TesteTecnicoFuria.blackClaw.repository.EventosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventosService {

    //Repositorys para logica de negocio
    private final EventosRepository eventosRepository;


    public Eventos save(Eventos eventos) {
        return eventosRepository.save(eventos);
    }

    public List<Eventos> findAll() {
        return eventosRepository.findAll();
    }

    public Optional<Eventos> findById(Long id) {
        return eventosRepository.findById(id);
    }

    public void deleteById(Long id) {
        eventosRepository.deleteById(id);
    }
}
