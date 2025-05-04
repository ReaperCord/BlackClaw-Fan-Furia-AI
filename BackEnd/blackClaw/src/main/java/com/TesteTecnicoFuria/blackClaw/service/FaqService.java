package com.TesteTecnicoFuria.blackClaw.service;

import com.TesteTecnicoFuria.blackClaw.Entity.Faq;
import com.TesteTecnicoFuria.blackClaw.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FaqService {

    private final FaqRepository faqRepository;

    public Faq save(Faq faq) {
        return faqRepository.save(faq);
    }

    public List<Faq> findAll() {
        return faqRepository.findAll();
    }

    public Optional<Faq> findById(Long id) {
        return faqRepository.findById(id);
    }

    public void deleteById(Long id) {
        faqRepository.deleteById(id);
    }
}
