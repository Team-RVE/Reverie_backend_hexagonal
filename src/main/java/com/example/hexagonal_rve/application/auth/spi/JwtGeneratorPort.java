package com.example.hexagonal_rve.application.auth.spi;

public interface JwtGeneratorPort {
  String generateAccessToken(String accountId);
  String generateRefreshToken(String accountId);
}
