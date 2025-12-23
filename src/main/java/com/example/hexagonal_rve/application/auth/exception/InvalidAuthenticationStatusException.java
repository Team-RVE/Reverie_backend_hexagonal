package com.example.hexagonal_rve.application.auth.exception;

import com.example.hexagonal_rve.application.global.handler.ErrorCode;
import com.example.hexagonal_rve.application.global.handler.RveApplicationException;

public class InvalidAuthenticationStatusException extends RveApplicationException {
  public InvalidAuthenticationStatusException() {
    super(ErrorCode.INVALID_AUTHENTICATION_CODE);
  }
}
