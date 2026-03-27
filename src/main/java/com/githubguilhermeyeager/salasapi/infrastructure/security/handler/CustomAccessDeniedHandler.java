package com.githubguilhermeyeager.salasapi.infrastructure.security.handler;

import com.githubguilhermeyeager.salasapi.application.dtos.DefaultGenericResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void handle(
            @NonNull HttpServletRequest request, HttpServletResponse response, @NonNull AccessDeniedException accessDeniedException
    ) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        DefaultGenericResponseDto<Object> errorBody = DefaultGenericResponseDto.error("Você não tem permissão para acessar este recurso.");

        response.getWriter().write(mapper.writeValueAsString(errorBody));
    }
}
