package com.letscode.santander811.championship.domains;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public class TeamMatchesResults {

    private final Team team;
    private final Set<MatchResult> matchesResults;

}
