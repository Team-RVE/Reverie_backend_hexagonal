package com.example.hexagonal_rve.application.auth.port.out;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface JwtManagerPort {
  String reissueAccessToken(String accountId,String refreshToken);
  UsernamePasswordAuthenticationToken getAuthentication(String accessToken);
}
