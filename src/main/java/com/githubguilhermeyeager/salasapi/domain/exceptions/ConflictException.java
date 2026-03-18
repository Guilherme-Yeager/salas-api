package com.githubguilhermeyeager.salasapi.domain.exceptions;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
