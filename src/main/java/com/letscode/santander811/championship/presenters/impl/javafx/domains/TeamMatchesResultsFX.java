package com.letscode.santander811.championship.presenters.impl.javafx.domains;

import lombok.Builder;
import lombok.Getter;

import java.util.Collection;

@Getter
@Builder
public class TeamMatchesResultsFX {

    private final String team;
    private final Collection<MatchResultFX> matchesResults;
}
