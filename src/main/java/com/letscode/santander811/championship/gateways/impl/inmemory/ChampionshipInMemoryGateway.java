package com.letscode.santander811.championship.gateways.impl.inmemory;

import com.letscode.santander811.championship.domains.Championship;
import com.letscode.santander811.championship.gateways.ChampionshipGateway;

import java.util.Map;
import java.util.Optional;

public class ChampionshipInMemoryGateway implements ChampionshipGateway {

    private static Map<String, Championship> dbInMemory = Map.of(
            "brasileirao2022",
            new Championship("brasileirao2022", "championshipResult2022.csv")
    );

    @Override
    public Optional<Championship> findById(String championshipId) {
        return Optional.ofNullable(dbInMemory.get(championshipId));
    }
}
