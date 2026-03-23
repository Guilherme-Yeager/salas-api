package com.githubguilhermeyeager.salasapi.infrastructure.exceptions.jwt;

public class JwtInvalidoException extends JwtExpiradoException {
    public JwtInvalidoException(String message) {
        super(message);
    }
}
