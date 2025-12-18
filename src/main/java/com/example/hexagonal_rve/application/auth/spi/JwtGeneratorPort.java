package com.example.hexagonal_rve.application.auth.spi;

public interface JwtGeneratorPort {
  String generateAccessToken(String email);
  String generateRefreshToken(String email);
}
