package com.example.hexagonal_rve.application.auth.port.in;

import com.example.hexagonal_rve.application.auth.port.in.command.VerifyCodeCommand;

public interface EmailVerificationUseCase {
  void sendCode(String email);
  void verifyCode(VerifyCodeCommand command);

}
