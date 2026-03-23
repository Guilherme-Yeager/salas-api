package com.githubguilhermeyeager.salasapi.infrastructure.exceptions;

public class JwtException extends RuntimeException {
    public JwtException(String message) {
        super(message);
    }
}
