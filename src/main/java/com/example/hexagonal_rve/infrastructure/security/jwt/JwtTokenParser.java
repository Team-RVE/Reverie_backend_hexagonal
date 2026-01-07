package com.example.hexagonal_rve.infrastructure.security.jwt;

import com.example.hexagonal_rve.application.auth.exception.JwtExpiredException;
import com.example.hexagonal_rve.application.auth.exception.JwtInvalidException;
import com.example.hexagonal_rve.application.auth.port.out.JwtParserPort;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtTokenParser implements JwtParserPort {


  private final SecretKey secretKey;

  public JwtTokenParser(JwtTokenGenerator jwtTokenGenerator) {
    this.secretKey=jwtTokenGenerator.getSecretKey();
  }

  //토큰의 값이 맞다면 1
  @Override
  public boolean validateAccessToken(String accessToken) {
    parseClaims(accessToken);
    return true;
  }

  @Override
  public boolean validateRefreshToken(String refreshToken) {
     parseClaims(refreshToken);
     return true;
  }

  @Override
  public Claims getClaimsFromAccessToken(String accessToken) {
    return parseClaims(accessToken);
  }

  private Claims parseClaims(String token) {
      try {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .getBody();
      } catch (ExpiredJwtException e) {
        throw new JwtExpiredException();
      }catch (JwtException e){
        throw new JwtInvalidException();
      }
  }

  @Override
  public String resolveToken(HttpServletRequest httpServletRequest) {
    String bearerToken = httpServletRequest.getHeader("Authorization");
    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7);
    }
    return null;
  }
}
