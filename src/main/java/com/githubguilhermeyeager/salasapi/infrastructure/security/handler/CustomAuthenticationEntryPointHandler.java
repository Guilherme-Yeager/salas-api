package com.githubguilhermeyeager.salasapi.infrastructure.security.handler;

import com.githubguilhermeyeager.salasapi.application.dtos.DefaultGenericResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPointHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(
            @NonNull HttpServletRequest request, HttpServletResponse response, @NonNull AuthenticationException authException
    ) throws IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String message;

        if (authException instanceof BadCredentialsException) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            message = "E-mail ou senha inválidos.";
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            message = "Acesso negado. Você precisa de um token válido para acessar este recurso.";
        }
        DefaultGenericResponseDto<Object> error = DefaultGenericResponseDto.error(message);

        response.getWriter().println(new ObjectMapper().writeValueAsString(error));
    }
}