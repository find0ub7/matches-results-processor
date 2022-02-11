package com.letscode.santander811.championship.gateways.impl.filesystem.parsers;

import com.letscode.santander811.championship.domains.MatchResult;
import com.letscode.santander811.championship.domains.Team;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MatchResultParser {

    public static final String DELIMITER = ";";
    public static final int TEAM1_INDEX = 0;
    public static final int TEAM2_INDEX = 1;
    public static final int SCORE1_INDEX = 2;
    public static final int SCORE2_INDEX = 3;
    public static final int DATE_INDEX = 4;

    public List<MatchResult> parse(List<String> lines) {
        return CollectionUtils.emptyIfNull(lines).stream()
                .map(this::parse)
                .collect(Collectors.toList());
    }

    public MatchResult parse(String line) {
        String[] matchResultProperties = line.split(DELIMITER);
        return MatchResult.builder()
                .team1(buildTeam(matchResultProperties[TEAM1_INDEX]))
                .team2(buildTeam(matchResultProperties[TEAM2_INDEX]))
                .score1(Integer.parseInt(matchResultProperties[SCORE1_INDEX]))
                .score2(Integer.parseInt(matchResultProperties[SCORE2_INDEX]))
                .date(LocalDate.parse(matchResultProperties[DATE_INDEX]))
                .build();
    }

    private Team buildTeam(String teamName) {
        return Team.builder().name(teamName).build();
    }
}
