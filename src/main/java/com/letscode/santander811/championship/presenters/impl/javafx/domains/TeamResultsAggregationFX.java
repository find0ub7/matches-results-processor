package com.letscode.santander811.championship.presenters.impl.javafx.domains;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeamResultsAggregationFX {

    private String teamName;
    private int victoriesCount;
    private int drawsCount;
    private int defeatsCount;
    private int totalScore;
}
