package com.letscode.santander811.championship.exceptions;

public class ChampionsipNotFoundException extends RuntimeException {
    public ChampionsipNotFoundException(String championshipId) {
        super("Championship not found for id " + championshipId);
    }
}
