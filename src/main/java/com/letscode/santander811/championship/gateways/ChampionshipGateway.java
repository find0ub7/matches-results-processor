package com.letscode.santander811.championship.gateways;

import com.letscode.santander811.championship.domains.Championship;

import java.util.Optional;

public interface ChampionshipGateway {

    Optional<Championship> findById(String championshipId);
}
