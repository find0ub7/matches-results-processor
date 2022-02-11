package com.letscode.santander811.championship.presenters.impl.javafx.domains;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MatchResultFX {

    private static final String lineFormat = "%s: %s %s x %s %s";

    private final String team1;
    private final String team2;
    private final int score1;
    private final int score2;
    private final String date;

    @Override
    public String toString() {
        return lineFormat.formatted(date, team1, score1, score2, team2);
    }
}
