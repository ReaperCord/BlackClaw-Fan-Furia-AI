package com.TesteTecnicoFuria.blackClaw.repository;

import com.TesteTecnicoFuria.blackClaw.Entity.Jogadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadoresRepository extends JpaRepository<Jogadores, Long> {
}
