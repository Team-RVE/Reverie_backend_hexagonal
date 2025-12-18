package com.example.hexagonal_rve.adapter.auth.in.dto.request;

import lombok.Getter;

@Getter
public class VerifyCodeRequest {
  private String email;
  private String code;
}
