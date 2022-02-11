package com.letscode.santander811.championship.presenters.impl.javafx.converters;

import com.letscode.santander811.championship.domains.TeamResultsAggregation;
import com.letscode.santander811.championship.presenters.impl.javafx.domains.TeamResultsAggregationFX;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class TeamResultsAggregationFXConverter {

    public Collection<TeamResultsAggregationFX> converter(Collection<TeamResultsAggregation> teamsResultsAggregation) {
        return teamsResultsAggregation.stream().map(this::converter).collect(toList());
    }

    public TeamResultsAggregationFX converter(TeamResultsAggregation teamResultsAggregation) {
        return TeamResultsAggregationFX.builder()
                .teamName(teamResultsAggregation.getTeamName())
                .totalScore(teamResultsAggregation.getTotalScore())
                .victoriesCount(teamResultsAggregation.getVictoriesCount())
                .drawsCount(teamResultsAggregation.getDrawsCount())
                .defeatsCount(teamResultsAggregation.getDefeatsCount())
                .build();
    }
}
