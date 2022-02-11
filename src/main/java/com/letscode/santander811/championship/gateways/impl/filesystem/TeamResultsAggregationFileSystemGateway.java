package com.letscode.santander811.championship.gateways.impl.filesystem;

import com.letscode.santander811.championship.domains.TeamResultsAggregation;
import com.letscode.santander811.championship.gateways.TeamResultsAggregationGateway;
import com.letscode.santander811.championship.gateways.impl.filesystem.converters.TeamResultsAggregationConverter;
import com.letscode.santander811.championship.utils.FileSystemUtils;

import java.util.Collection;

public class TeamResultsAggregationFileSystemGateway implements TeamResultsAggregationGateway {

    public static final String RANK_FILE_PATH = "target/rank/championship-ranking.csv";
    private final TeamResultsAggregationConverter teamResultsAggregationConverter =
            new TeamResultsAggregationConverter();

    @Override
    public Collection<TeamResultsAggregation> save(Collection<TeamResultsAggregation> resultAggregations) {
        var aggregationLines = teamResultsAggregationConverter.convert(resultAggregations);
        FileSystemUtils.write(RANK_FILE_PATH, aggregationLines);
        return resultAggregations;
    }
}
