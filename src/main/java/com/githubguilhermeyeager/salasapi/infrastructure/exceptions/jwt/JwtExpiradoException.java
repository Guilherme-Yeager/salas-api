package com.githubguilhermeyeager.salasapi.infrastructure.exceptions.jwt;

import com.githubguilhermeyeager.salasapi.infrastructure.exceptions.JwtException;

public class JwtExpiradoException extends JwtException {
    public JwtExpiradoException(String message) {
        super(message);
    }
}
