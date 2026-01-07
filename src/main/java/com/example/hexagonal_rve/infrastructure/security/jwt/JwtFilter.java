package com.example.hexagonal_rve.infrastructure.security.jwt;

import com.example.hexagonal_rve.application.auth.port.out.JwtManagerPort;
import com.example.hexagonal_rve.application.auth.port.out.JwtParserPort;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

  private final JwtParserPort jwtParserPort;
  private final JwtManagerPort jwtManagerPort;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String token = jwtParserPort.resolveToken(request);
    if(token != null) {
      Authentication authentication = jwtManagerPort.getAuthentication(token);
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    filterChain.doFilter(request, response);
  }
}
