package com.TesteTecnicoFuria.blackClaw.controller.request;

import java.util.List;

public record MapasRequest(List<Long> partidasId,
                           String nomeMapa) {
}
