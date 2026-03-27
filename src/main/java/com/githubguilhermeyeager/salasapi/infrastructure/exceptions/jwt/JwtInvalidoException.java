package com.githubguilhermeyeager.salasapi.infrastructure.exceptions.jwt;

import com.githubguilhermeyeager.salasapi.infrastructure.exceptions.JwtException;

public class JwtInvalidoException extends JwtException {
    public JwtInvalidoException(String message) {
        super(message);
    }
}
