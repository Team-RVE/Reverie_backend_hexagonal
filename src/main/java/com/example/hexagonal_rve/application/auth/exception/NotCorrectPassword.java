package com.example.hexagonal_rve.application.auth.exception;

import com.example.hexagonal_rve.application.global.handler.ErrorCode;
import com.example.hexagonal_rve.application.global.handler.RveApplicationException;

public class NotCorrectPassword extends RveApplicationException {
  public NotCorrectPassword() {
    super(ErrorCode.NOT_CORRECT_PASSWORD);
  }
}
