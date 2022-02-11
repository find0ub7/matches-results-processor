package com.letscode.santander811.championship.gateways.impl.filesystem;

import com.letscode.santander811.championship.domains.TeamMatchesResults;
import com.letscode.santander811.championship.gateways.TeamMatchesResultsGateway;
import com.letscode.santander811.championship.gateways.impl.filesystem.converters.TeamMatchesResultsConverter;
import com.letscode.santander811.championship.utils.FileSystemUtils;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.deleteWhitespace;
import static org.apache.commons.lang3.StringUtils.stripAccents;

public class TeamMatchesResultsFileSystemGateway implements TeamMatchesResultsGateway {

    public static final String TEAM_RESULTS_FILE_PATH_PATTERN = "target/teams/%s-all-matches.txt";
    private final TeamMatchesResultsConverter teamMatchesResultsConverter =
            new TeamMatchesResultsConverter();

    @Override
    public List<TeamMatchesResults> save(List<TeamMatchesResults> teamMatchesResults) {
        teamMatchesResults.forEach(temMatchesResults -> {
            var matchesResults = temMatchesResults.getMatchesResults();
            var team = temMatchesResults.getTeam();

            var matchesResultsLines = teamMatchesResultsConverter.convert(matchesResults);
            var teamNameWithoutAccents = stripAccents(deleteWhitespace(team.getName()));
            FileSystemUtils.write(
                    TEAM_RESULTS_FILE_PATH_PATTERN.formatted(teamNameWithoutAccents),
                    matchesResultsLines);
        });

        return teamMatchesResults;
    }
}
