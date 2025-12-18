package com.example.hexagonal_rve.application.auth.port.in;

import com.example.hexagonal_rve.application.auth.port.in.command.SignInCommand;

public interface SignInUseCase {
  void signIn(SignInCommand command);
}
