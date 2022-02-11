package com.letscode.santander811.championship.usecases;

import com.letscode.santander811.championship.domains.ChampionshipProcessResult;
import com.letscode.santander811.championship.gateways.MatchResultGateway;
import com.letscode.santander811.championship.gateways.TeamMatchesResultsGateway;
import com.letscode.santander811.championship.gateways.TeamResultsAggregationGateway;
import com.letscode.santander811.championship.gateways.impl.filesystem.MatchResultFileSystemGateway;
import com.letscode.santander811.championship.gateways.impl.filesystem.TeamMatchesResultsFileSystemGateway;
import com.letscode.santander811.championship.gateways.impl.filesystem.TeamResultsAggregationFileSystemGateway;

public class ProcessMatchesResults {

    private final MatchResultGateway matchResultGateway = new MatchResultFileSystemGateway();
    private final GroupMatchesResultByTeam groupMatchesResultByTeam = new GroupMatchesResultByTeam();
    private final TeamMatchesResultsGateway teamMatchesResultsGateway = new TeamMatchesResultsFileSystemGateway();
    private final AggregateTeamMatchesResult aggregateTeamMatchesResult = new AggregateTeamMatchesResult();
    private final TeamResultsAggregationGateway teamResultsAggregationGateway = new TeamResultsAggregationFileSystemGateway();

    public ChampionshipProcessResult execute(String championshipId) {
        var matchResults = matchResultGateway.findByChampionshipId(championshipId);
        var teamsMatchesResults = groupMatchesResultByTeam.execute(matchResults);
        teamMatchesResultsGateway.save(teamsMatchesResults);
        var resultsAggregation = aggregateTeamMatchesResult.execute(teamsMatchesResults);
        teamResultsAggregationGateway.save(resultsAggregation);
        System.out.println("Matches results processing has been completed!");

        return ChampionshipProcessResult.builder()
                .championshipId(championshipId)
                .teamsMatchesResults(teamsMatchesResults)
                .teamsResultsAggregation(resultsAggregation)
                .build();
    }

}
