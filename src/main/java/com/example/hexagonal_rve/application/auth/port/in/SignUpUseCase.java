package com.example.hexagonal_rve.application.auth.port.in;


import com.example.hexagonal_rve.application.auth.port.in.command.SignUpCommand;

public interface SignUpUseCase {
  void signUp(SignUpCommand command);
}
