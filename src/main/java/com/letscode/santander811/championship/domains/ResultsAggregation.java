package com.letscode.santander811.championship.domains;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResultsAggregation {

    private final int victories;
    private final int defeats;
    private final int draws;
    private final int totalScore;
}
