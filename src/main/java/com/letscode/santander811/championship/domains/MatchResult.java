package com.letscode.santander811.championship.domains;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MatchResult {

    private final Team team1;
    private final Team team2;
    private final int score1;
    private final int score2;
    private final LocalDate date;

    public String getNameTeam1() {
        return team1.getName();
    }

    public String getNameTeam2() {
        return team2.getName();
    }

    public ResultType getResultType(Team team) {
        int balance = getBalance(team);
        return ResultType.getByBalance(balance);
    }

    private int getBalance(Team team) {
        if (!team.equals(team1) && !team.equals(team2))
            throw new IllegalArgumentException("Team is not in the match!");

        boolean home = team1.equals(team);
        return (int)(home ? Math.signum(score1 - score2) : Math.signum(score2 - score1)); //        return (int)(Math.signum(score1 - score2) * (home ? 1 : -1)); //outra opcao
    }

}
