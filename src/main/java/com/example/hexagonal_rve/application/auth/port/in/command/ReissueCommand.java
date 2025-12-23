package com.example.hexagonal_rve.application.auth.port.in.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReissueCommand {
  private final String email;
  private final String refreshToken;
}
