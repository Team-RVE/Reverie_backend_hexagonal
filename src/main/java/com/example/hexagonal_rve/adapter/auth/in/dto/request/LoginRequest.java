package com.example.hexagonal_rve.adapter.auth.in.dto.request;

import lombok.Getter;

@Getter
public class LoginRequest {
  private String email;
  private String password;
}
