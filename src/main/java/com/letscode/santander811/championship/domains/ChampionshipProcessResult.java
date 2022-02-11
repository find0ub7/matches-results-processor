package com.letscode.santander811.championship.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;

@Getter
@Builder
@ToString
public class ChampionshipProcessResult {

    private final String championshipId;
    private final Collection<TeamMatchesResults> teamsMatchesResults;
    private final Collection<TeamResultsAggregation> teamsResultsAggregation;
}
