package com.example.hexagonal_rve.adapter.auth.in.dto.request;

import lombok.Getter;

@Getter
public class ReissueRequest {
  private String email;
  private String refreshToken;
}
