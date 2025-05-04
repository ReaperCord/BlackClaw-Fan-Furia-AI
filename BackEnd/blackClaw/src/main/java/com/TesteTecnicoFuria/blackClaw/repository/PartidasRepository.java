package com.TesteTecnicoFuria.blackClaw.repository;

import com.TesteTecnicoFuria.blackClaw.Entity.Partidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidasRepository extends JpaRepository<Partidas, Long> {
}
