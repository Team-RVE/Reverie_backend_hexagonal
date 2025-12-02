package com.example.hexagonal_rve.application.auth.spi;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

public interface JwtParserPort {
  boolean validateAccessToken(String accessToken);
  boolean validateRefreshToken(String refreshToken);
  Claims getClaimsFromAccessToken(String accessToken);
  String resolveToken(HttpServletRequest request);
}
