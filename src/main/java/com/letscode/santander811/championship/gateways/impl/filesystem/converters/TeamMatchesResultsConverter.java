package com.letscode.santander811.championship.gateways.impl.filesystem.converters;

import com.letscode.santander811.championship.domains.MatchResult;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class TeamMatchesResultsConverter {

    public static final String DATE_PATTERN = "dd/MM/yyyy";
    public static final String LINE_PATTERN = "%s: %s %s x %s %s";

    public List<String> convert(Collection<MatchResult> matchResults) {
        return matchResults.stream().map(this::convert).collect(toList());
    }

    private String convert(MatchResult matchResult) {
        return LINE_PATTERN.formatted(
                matchResult.getDate().format(DateTimeFormatter.ofPattern(DATE_PATTERN)),
                matchResult.getNameTeam1(),
                matchResult.getScore1(),
                matchResult.getScore2(),
                matchResult.getNameTeam2());
    }
}
