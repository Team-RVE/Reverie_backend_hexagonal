package com.example.hexagonal_rve.application.auth.port.in;

import com.example.hexagonal_rve.application.auth.port.in.command.SetPasswordCommand;

public interface SetPasswordUseCase {
  void setPassword(SetPasswordCommand command);
}
