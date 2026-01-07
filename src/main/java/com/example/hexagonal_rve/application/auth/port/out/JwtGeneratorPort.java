package com.example.hexagonal_rve.application.auth.port.out;

public interface JwtGeneratorPort {
  String generateAccessToken(String email);
  String generateRefreshToken(String email);
}
