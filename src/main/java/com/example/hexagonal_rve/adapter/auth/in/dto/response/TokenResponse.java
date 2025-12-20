package com.example.hexagonal_rve.adapter.auth.in.dto.response;

import lombok.Builder;

@Builder
public class TokenResponse {
  private String refreshToken;
  private String accessToken;
}
