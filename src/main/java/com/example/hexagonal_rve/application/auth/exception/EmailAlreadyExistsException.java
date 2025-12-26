package com.example.hexagonal_rve.application.auth.exception;

import com.example.hexagonal_rve.application.global.handler.ErrorCode;
import com.example.hexagonal_rve.application.global.handler.RveApplicationException;

public class EmailAlreadyExistsException extends RveApplicationException {
  public EmailAlreadyExistsException() {
    super(ErrorCode.EMAIL_ALREADY_EXISTS);
  }
}
