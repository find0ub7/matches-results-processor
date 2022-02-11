package com.letscode.santander811.championship.presenters.impl.javafx.converters;

import com.letscode.santander811.championship.domains.MatchResult;
import com.letscode.santander811.championship.presenters.impl.javafx.domains.MatchResultFX;

import java.time.format.DateTimeFormatter;
import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class MatchResultFXConverter {

    public Collection<MatchResultFX> convert(Collection<MatchResult> matchesResults) {
        return matchesResults.stream().map(this::convert).collect(toList());
    }

    public MatchResultFX convert(MatchResult matchesResult) {
        return MatchResultFX.builder()
                .team1(matchesResult.getNameTeam1())
                .team2(matchesResult.getNameTeam2())
                .score1(matchesResult.getScore1())
                .score2(matchesResult.getScore2())
                .date(matchesResult.getDate().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")))
                .build();
    }
}
