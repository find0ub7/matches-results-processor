package com.letscode.santander811.championship.domains;

import com.letscode.santander811.championship.exceptions.ResultTypeNotFound;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ResultType {
    VICTORY(3, 1),
    DRAW(1, 0),
    DEFEAT(0, -1);

    private final int points;
    private final int balance;

    public static ResultType getByBalance(int balance) {
        return Arrays.stream(values())
                .filter(type -> type.balance == balance)
                .findFirst()
                .orElseThrow(() -> new ResultTypeNotFound("Result type not found for balance: " + balance));
    }
}
