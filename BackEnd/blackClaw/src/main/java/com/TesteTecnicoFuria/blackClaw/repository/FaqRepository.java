package com.TesteTecnicoFuria.blackClaw.repository;

import com.TesteTecnicoFuria.blackClaw.Entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Long> {
}
