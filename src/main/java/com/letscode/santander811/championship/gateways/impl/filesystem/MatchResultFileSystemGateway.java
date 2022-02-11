package com.letscode.santander811.championship.gateways.impl.filesystem;

import com.letscode.santander811.championship.domains.Championship;
import com.letscode.santander811.championship.domains.MatchResult;
import com.letscode.santander811.championship.exceptions.ChampionsipNotFoundException;
import com.letscode.santander811.championship.gateways.ChampionshipGateway;
import com.letscode.santander811.championship.gateways.MatchResultGateway;
import com.letscode.santander811.championship.gateways.impl.filesystem.parsers.MatchResultParser;
import com.letscode.santander811.championship.gateways.impl.inmemory.ChampionshipInMemoryGateway;
import com.letscode.santander811.championship.utils.FileSystemUtils;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MatchResultFileSystemGateway implements MatchResultGateway {

    private final MatchResultParser matchResultParser = new MatchResultParser();
    private final ChampionshipGateway championshipGateway = new ChampionshipInMemoryGateway();

    @Override
    public Collection<MatchResult> findByChampionshipId(String championshipId) {
        var fileName = championshipGateway.findById(championshipId)
                .map(Championship::getFilename)
                .orElseThrow(() -> new ChampionsipNotFoundException(championshipId));

        var fileLines = FileSystemUtils.readLines(fileName);
        var matchesResultLines = fileLines.stream().skip(1).collect(toList());
        return matchResultParser.parse(matchesResultLines);
    }

}
