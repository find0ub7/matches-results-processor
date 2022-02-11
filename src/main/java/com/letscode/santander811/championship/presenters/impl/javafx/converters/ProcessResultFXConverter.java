package com.letscode.santander811.championship.presenters.impl.javafx.converters;

import com.letscode.santander811.championship.domains.ChampionshipProcessResult;
import com.letscode.santander811.championship.presenters.impl.javafx.domains.ChampionshipProcessResultFX;

public class ProcessResultFXConverter {

    private final TeamMatchesResultsFXConverter teamMatchesResultsFXConverter = new TeamMatchesResultsFXConverter();
    private final TeamResultsAggregationFXConverter teamResultsAggregationFXConverter = new TeamResultsAggregationFXConverter();

    public ChampionshipProcessResultFX convert(ChampionshipProcessResult championshipProcessResult) {
        var teamsMatchesResultsFX = teamMatchesResultsFXConverter.convert(championshipProcessResult.getTeamsMatchesResults());
        var teamsResultsAggregationFX = teamResultsAggregationFXConverter.converter(championshipProcessResult.getTeamsResultsAggregation());

        return ChampionshipProcessResultFX.builder()
                .championshipId(championshipProcessResult.getChampionshipId())
                .teamsMatchesResults(teamsMatchesResultsFX)
                .teamsResultsAggregation(teamsResultsAggregationFX)
                .build();
    }
}
