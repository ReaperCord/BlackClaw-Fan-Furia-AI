package com.TesteTecnicoFuria.blackClaw.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public enum TipoContrato {
    ATIVO("Ativo", "ativo", "ATIVO", "ATIV0", "Ativ", "ativ", "Ativado", "ATIVADO"),
    BANCODERESERVA("Banco de Reserva", "banco de reserva", "BANCODERESERVA", "BANCODERESERVAS", "Banco de Reservas", "Banco de Reserva", "Banco de Reserva", "Banco de Reserva"),
    DESATIVADO("Desativado", "desativado", "DESATIVAD", "DESATIVADOS", "Desativa", "Desativad", "desativado", "desativados"),
    TEMPORARIO("Temporário", "temporário", "TEMPORARIO", "TEMPORARIO", "Temporario", "temporari", "temporario", "temporarios");

    private final String descricao;
    private final String[] equivalentes;
    private static Map<String, TipoContrato> LOOKUP = new HashMap<>();

    static {
        LOOKUP = Arrays.stream(TipoContrato.values())
                .flatMap(tipo -> Stream.concat(
                        Arrays.stream(tipo.equivalentes),
                        Stream.of(tipo.descricao)
                ).map(equivalente -> new AbstractMap.SimpleEntry<>(equivalente.toLowerCase(), tipo)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (tipo1, tipo2) -> tipo1));
    }

    TipoContrato(String descricao, String... equivalentes) {
        this.descricao = descricao;
        this.equivalentes = equivalentes;
    }

    @JsonCreator
    public static TipoContrato fromValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Tipo de contrato inválido: " + value);
        }

        TipoContrato tipoContrato = LOOKUP.get(value.toLowerCase());
        if (tipoContrato != null) {
            return tipoContrato;
        }

        throw new IllegalArgumentException("Tipo de contrato inválido: " + value);
    }
}
