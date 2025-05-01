package com.TesteTecnicoFuria.blackClaw.controller.request;

import java.util.List;

public record ResultadosRequest(List<Long> mapaId,
                                List<Long> jogadorId,
                                Integer abates,
                                Integer mortes,
                                Integer diferenca,
                                Double adr,
                                Double kast,
                                Double rating) {
}
