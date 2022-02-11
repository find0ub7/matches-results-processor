package com.letscode.santander811.championship.gateways;

import com.letscode.santander811.championship.domains.TeamResultsAggregation;

import java.util.Collection;

public interface TeamResultsAggregationGateway {

    Collection<TeamResultsAggregation> save(Collection<TeamResultsAggregation> resultAggregations);
}
