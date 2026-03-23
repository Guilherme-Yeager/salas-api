package com.githubguilhermeyeager.salasapi.infrastructure.security;

import com.githubguilhermeyeager.salasapi.application.dtos.DefaultGenericResponseDto;
import com.githubguilhermeyeager.salasapi.infrastructure.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {

        String path = request.getServletPath();

        if(path.equals("/auth/login")){
            filterChain.doFilter(request,response);
            return;
        }

        String authHeader = request.getHeader("Authorization");
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            String token = authHeader.replace("Bearer ","");

            try {
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(tokenService.verificarToken(token), null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (Exception e){
                SecurityContextHolder.clearContext();
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setCharacterEncoding("UTF-8");
                ObjectMapper mapper = new ObjectMapper();
                response.getWriter().println(mapper.writeValueAsString(DefaultGenericResponseDto.error("Token inválido ou expirado.")));
                return;
            }
        }
        filterChain.doFilter(request,response);
    }
}
