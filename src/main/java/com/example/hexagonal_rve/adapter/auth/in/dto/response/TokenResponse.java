package com.example.hexagonal_rve.adapter.auth.in.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {
  private String refreshToken;
  private String accessToken;
}
