package com.TesteTecnicoFuria.blackClaw.repository;

import com.TesteTecnicoFuria.blackClaw.Entity.Mapas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapaRepository extends JpaRepository<Mapas, Long> {
}
