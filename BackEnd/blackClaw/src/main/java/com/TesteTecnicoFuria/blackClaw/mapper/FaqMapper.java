package com.TesteTecnicoFuria.blackClaw.mapper;

import com.TesteTecnicoFuria.blackClaw.Entity.Faq;
import com.TesteTecnicoFuria.blackClaw.controller.request.FaqRequest;
import com.TesteTecnicoFuria.blackClaw.controller.response.FaqResponse;

public class FaqMapper {

    public static Faq toFaq(FaqRequest faqRequest) {
        return Faq.builder()
                .pergunta(faqRequest.pergunta())
                .resposta(faqRequest.resposta())
                .build();
    }

    public static FaqResponse toResponse(Faq faq) {
        return FaqResponse.builder()
                .pergunta(faq.getPergunta())
                .resposta(faq.getResposta())
                .build();
    }
}
