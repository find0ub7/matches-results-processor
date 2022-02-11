package com.letscode.santander811.championship.presenters.impl.javafx.converters;

import com.letscode.santander811.championship.domains.TeamMatchesResults;
import com.letscode.santander811.championship.presenters.impl.javafx.domains.TeamMatchesResultsFX;

import java.util.Collection;
import java.util.stream.Collectors;

public class TeamMatchesResultsFXConverter {

    private final MatchResultFXConverter matchResultFXConverter = new MatchResultFXConverter();

    public Collection<TeamMatchesResultsFX> convert(Collection<TeamMatchesResults> teamsMatchesResults) {
        return teamsMatchesResults.stream().map(this::convert).collect(Collectors.toList());
    }

    public TeamMatchesResultsFX convert(TeamMatchesResults teamsMatchesResults) {
        return TeamMatchesResultsFX.builder()
                .team(teamsMatchesResults.getTeam().getName())
                .matchesResults(matchResultFXConverter.convert(teamsMatchesResults.getMatchesResults()))
                .build();
    }
}
