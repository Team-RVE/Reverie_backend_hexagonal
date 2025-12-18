package com.example.hexagonal_rve.application.auth.exception;

import com.example.hexagonal_rve.application.global.handler.ErrorCode;
import com.example.hexagonal_rve.application.global.handler.RveApplicationException;

public class NotCorrectCodeException extends RveApplicationException {
  public NotCorrectCodeException() {
    super(ErrorCode.NOT_CORRECT_CODE);
  }
}
