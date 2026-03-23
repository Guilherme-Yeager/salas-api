package com.githubguilhermeyeager.salasapi.infrastructure.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.githubguilhermeyeager.salasapi.application.dtos.login.responses.LoginResponseDto;
import com.githubguilhermeyeager.salasapi.infrastructure.exceptions.jwt.JwtExpiradoException;
import com.githubguilhermeyeager.salasapi.infrastructure.exceptions.jwt.JwtInvalidoException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${spring.secret}")
    private String secret;

    @Value("${spring.expiration}")
    private long expriration;

    @Value("${spring.emissor}")
    private String emissor;

    public LoginResponseDto gerarToken(String email) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return new LoginResponseDto(
                JWT.create()
                        .withIssuer(emissor)
                        .withSubject(email)
                        .withExpiresAt(this.getTokenExpiracao())
                        .sign(algorithm)
        );
    }

    public String verificarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(emissor)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (TokenExpiredException e) {
            throw new JwtExpiradoException("O token expirou, faça login novamente!");
        } catch (JWTVerificationException e) {
            throw new JwtInvalidoException("Token inválido ou corrompido.");
        }
    }

    private Instant getTokenExpiracao() {
        return LocalDateTime.now().plusMinutes(expriration).toInstant(ZoneOffset.of("-03:00"));
    }
}
