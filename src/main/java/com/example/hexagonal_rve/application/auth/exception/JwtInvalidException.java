package com.example.hexagonal_rve.application.auth.exception;

import com.example.hexagonal_rve.application.global.handler.ErrorCode;
import com.example.hexagonal_rve.application.global.handler.RveApplicationException;

public class JwtInvalidException extends RveApplicationException {
  public JwtInvalidException() {
    super(ErrorCode.JWT_INVALID);
  }
}
