package com.example.hexagonal_rve.adapter.auth.in.dto.request;

import lombok.Getter;

@Getter
public class SetPasswordRequest {
  private String email;
  private String password;
}
