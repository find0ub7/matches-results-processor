package com.letscode.santander811.championship.usecases;

import com.letscode.santander811.championship.domains.*;

import java.util.*;
import java.util.stream.Collectors;

import static com.letscode.santander811.championship.domains.ResultType.DRAW;
import static com.letscode.santander811.championship.domains.ResultType.VICTORY;
import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class AggregateTeamMatchesResult {

    public Collection<TeamResultsAggregation> execute(List<TeamMatchesResults> teamMatchesResults) {
        return teamMatchesResults.stream()
                .map(teamResults -> aggregateResults(teamResults.getTeam(), teamResults.getMatchesResults()))
                .collect(Collectors.toCollection(this::sortedSet));
    }

    private TeamResultsAggregation aggregateResults(Team team, Set<MatchResult> matchesResults) {
        var countResultByType =
                matchesResults.stream()
                        .map(matchResult -> matchResult.getResultType(team))
                        .collect(groupingBy(identity(), counting()));

        int victories = countResultByType.getOrDefault(VICTORY, 0L).intValue();
        int draws = countResultByType.getOrDefault(DRAW, 0L).intValue();
        int defeats = countResultByType.getOrDefault(ResultType.DEFEAT, 0L).intValue();
        int totalScore = VICTORY.getPoints() * victories + DRAW.getPoints() * draws;

        var resultsAggregation =
                ResultsAggregation.builder()
                        .totalScore(totalScore)
                        .victories(victories)
                        .draws(draws)
                        .defeats(defeats)
                        .build();

        return TeamResultsAggregation.builder()
                .team(team)
                .resultsAggregation(resultsAggregation)
                .build();
    }

    private SortedSet<TeamResultsAggregation> sortedSet() {
        return new TreeSet<>(
                comparing(TeamResultsAggregation::getTotalScore, reverseOrder())
                        .thenComparing(TeamResultsAggregation::getVictoriesCount, reverseOrder())
                        .thenComparing(TeamResultsAggregation::getTeamName));
    }
}
