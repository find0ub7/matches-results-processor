package com.letscode.santander811.championship.gateways.impl.filesystem.converters;

import com.letscode.santander811.championship.domains.TeamResultsAggregation;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class TeamResultsAggregationConverter {

    public static final String RANKING_LINE_PATTERN = "%s;%s;%s;%s;%s";

    public List<String> convert(Collection<TeamResultsAggregation> resultAggregations) {
        return resultAggregations.stream().map(this::convert).collect(toList());
    }

    public String convert(TeamResultsAggregation resultAggregation) {
        return RANKING_LINE_PATTERN.formatted(
                resultAggregation.getTeamName(),
                resultAggregation.getVictoriesCount(),
                resultAggregation.getDrawsCount(),
                resultAggregation.getDefeatsCount(),
                resultAggregation.getTotalScore());
    }
}
