package com.letscode.santander811.championship.gateways;

import com.letscode.santander811.championship.domains.MatchResult;

import java.util.Collection;

public interface MatchResultGateway {

    Collection<MatchResult> findByChampionshipId(String championshipId);
}
