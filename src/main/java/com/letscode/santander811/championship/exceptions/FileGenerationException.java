package com.letscode.santander811.championship.exceptions;

public class FileGenerationException extends RuntimeException {
    public FileGenerationException(Exception e) {
        super(e);
    }
}
