package com.letscode.santander811.championship.gateways;

import com.letscode.santander811.championship.domains.TeamMatchesResults;

import java.util.List;

public interface TeamMatchesResultsGateway {

    List<TeamMatchesResults> save(List<TeamMatchesResults> teamMatchesResults);
}
