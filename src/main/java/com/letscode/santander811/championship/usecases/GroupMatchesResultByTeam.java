package com.letscode.santander811.championship.usecases;

import com.letscode.santander811.championship.domains.MatchResult;
import com.letscode.santander811.championship.domains.Team;
import com.letscode.santander811.championship.domains.TeamMatchesResults;

import java.util.*;

import static java.util.stream.Collectors.*;

public class GroupMatchesResultByTeam {

    public List<TeamMatchesResults> execute(Collection<MatchResult> matchesResults) {
        var uniqueMatchesResults = new HashSet<>(matchesResults);

//        return groupBySegregatingHomeAndVisitorMatches(uniqueMatchesResults);
        return groupByTeam(uniqueMatchesResults)
                .entrySet()
                .stream()
                .map(teamResults -> new TeamMatchesResults(teamResults.getKey(), teamResults.getValue()))
                .collect(toList());
    }

    //Opcao sem ter a necessidade da divisao dos maps por mandante/visitante
    private Map<Team, Set<MatchResult>> groupByTeam(Set<MatchResult> uniqueMatchesResults) {
        Map<Team, Set<MatchResult>> allMatchesByTeam = new TreeMap<>(Comparator.comparing(Team::getName));
        uniqueMatchesResults.stream().forEach(match -> {
            var team1 = match.getTeam1();
            var team2 = match.getTeam2();
            var team1Matches = allMatchesByTeam.getOrDefault(team1, sortedSet());
            var team2Matches = allMatchesByTeam.getOrDefault(team2, sortedSet());
            team1Matches.add(match);
            team2Matches.add(match);
            allMatchesByTeam.put(team1, team1Matches);
            allMatchesByTeam.put(team2, team2Matches);
        });

        return allMatchesByTeam;
    }

    private Set<MatchResult> sortedSet() {
        return new TreeSet<>(
                Comparator.comparing(MatchResult::getDate)
                        .thenComparing(MatchResult::getNameTeam1)
                        .thenComparing(MatchResult::getNameTeam2));
    }

    private Map<Team, Set<MatchResult>> groupBySegregatingHomeAndVisitorMatches(Set<MatchResult> uniqueMatchesResults) {
        var homeTeamMatchesResults =
                uniqueMatchesResults.stream()
                        .collect(groupingBy(MatchResult::getTeam1, toCollection(this::sortedSet)));

        var visitorTeamMatchesResults =
                uniqueMatchesResults.stream()
                        .collect(groupingBy(MatchResult::getTeam2, toCollection(this::sortedSet)));

        return joinMatches(homeTeamMatchesResults, visitorTeamMatchesResults);
    }

    private Map<Team, Set<MatchResult>> joinMatches(
            Map<Team, Set<MatchResult>> homeTeamMatchesResults,
            Map<Team, Set<MatchResult>> visitorTeamMatchesResults) {
        Map<Team, Set<MatchResult>> allMatchesByTeam =
                new TreeMap<>(Comparator.comparing(Team::getName));

        homeTeamMatchesResults.forEach(
                (team, homeTeamMatches) -> {
                    Set<MatchResult> teamMatchesResults = allMatchesByTeam.getOrDefault(team, sortedSet());
                    teamMatchesResults.addAll(homeTeamMatches);

                    Set<MatchResult> visitorTeamMatches =
                            visitorTeamMatchesResults.getOrDefault(team, sortedSet());
                    teamMatchesResults.addAll(visitorTeamMatches);

                    allMatchesByTeam.put(team, teamMatchesResults);
                });

        return allMatchesByTeam;
    }

}
