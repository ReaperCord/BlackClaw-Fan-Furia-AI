package com.TesteTecnicoFuria.blackClaw.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum FuncaoInGame {
    ENTRYFRAGGER("Entry Fragger", "ENTRY FRAGGER", "ENTRY", "entry"),
    SUPORTE("Suporte", "SUPORTE", "SUPPORT", "support", "SUP", "sup", "Sup"),
    AWPer("AWPer", "AWPER", "Awp", "awp", "AWP"),
    LURKER("Lurker", "LURKER", "lurker", "ANCORA", "Ancora", "ancora"),
    IGL("In-Game Leader", "IN GAME LEADER", "in game leader", "INGAME LEADER", "ingame leader", "Igl", "IGL", "", "igl");

    private final String descricao;
    private final String[] equivalentes;
    private static Map<String, FuncaoInGame> LOOKUP = new HashMap<>();

    static {
        LOOKUP = Arrays.stream(FuncaoInGame.values())
                .flatMap(tipo -> Stream.concat(
                        Arrays.stream(tipo.equivalentes),
                        Stream.of(tipo.descricao)
                ).map(equivalente -> new AbstractMap.SimpleEntry<>(equivalente.toLowerCase(), tipo)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (tipo1, tipo2) -> tipo1));
    }

    FuncaoInGame(String descricao, String... equivalentes) {
        this.descricao = descricao;
        this.equivalentes = equivalentes;
    }

    @JsonCreator
    public static FuncaoInGame fromValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Tipo de posição inválida: " + value);
        }

        FuncaoInGame funcaoInGame = LOOKUP.get(value.toLowerCase());
        if (funcaoInGame != null) {
            return funcaoInGame;
        }

        throw new IllegalArgumentException("Tipo de posição inválida: " + value);
    }

}
