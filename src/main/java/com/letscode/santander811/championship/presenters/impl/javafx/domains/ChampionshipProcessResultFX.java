package com.letscode.santander811.championship.presenters.impl.javafx.domains;

import lombok.Builder;
import lombok.Getter;

import java.util.Collection;
import java.util.List;

@Getter
@Builder
public class ChampionshipProcessResultFX {

    private final String championshipId;
    private final Collection<TeamMatchesResultsFX> teamsMatchesResults;
    private final Collection<TeamResultsAggregationFX> teamsResultsAggregation;


    public Collection<MatchResultFX> getMatchesByTeam(String teamName) {
        return teamsMatchesResults.stream()
                .filter(teamMatchesResultsFX -> teamMatchesResultsFX.getTeam().equals(teamName))
                .findFirst()
                .map(TeamMatchesResultsFX::getMatchesResults)
                .orElse(List.of());
    }
}
