package com.example.hexagonal_rve.infrastructure.security.jwt;

import com.example.hexagonal_rve.application.auth.spi.JwtGeneratorPort;
import com.example.hexagonal_rve.application.auth.spi.JwtManagerPort;
import com.example.hexagonal_rve.application.auth.spi.JwtParserPort;
import com.example.hexagonal_rve.infrastructure.security.auth.CustomUserDetails;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenManager implements JwtManagerPort {
  private final JwtParserPort jwtParser;
  private final JwtGeneratorPort jwtGenerator;
  private final UserDetailsService userDetailsService;

  @Override
  public String reissueAccessToken(String email,String refreshToken) {
    jwtParser.validateRefreshToken(refreshToken);
    return jwtGenerator.generateAccessToken(email);
  }

  @Override
  public UsernamePasswordAuthenticationToken getAuthentication(String accessToken) {
    Claims claims = jwtParser.getClaimsFromAccessToken(accessToken);
    CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(claims.getSubject());
    return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
  }
}
