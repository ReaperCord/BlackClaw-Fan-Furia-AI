package com.TesteTecnicoFuria.blackClaw.repository;

import com.TesteTecnicoFuria.blackClaw.Entity.ProximosJogos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProximosJogosRepository extends JpaRepository<ProximosJogos, Long> {
}
