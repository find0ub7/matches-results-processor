package com.letscode.santander811.championship.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class TeamResultsAggregation {

    private final Team team;
    private final ResultsAggregation resultsAggregation;

    public String getTeamName() {
        return team.getName();
    }

    public int getVictoriesCount() {
        return resultsAggregation.getVictories();
    }

    public int getDrawsCount() {
        return resultsAggregation.getDraws();
    }

    public int getDefeatsCount() {
        return resultsAggregation.getDefeats();
    }

    public int getTotalScore() {
        return resultsAggregation.getTotalScore();
    }
}
