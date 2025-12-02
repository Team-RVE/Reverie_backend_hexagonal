package com.example.hexagonal_rve.application.auth.exception;

import com.example.hexagonal_rve.application.global.handler.ErrorCode;
import com.example.hexagonal_rve.application.global.handler.RveApplicationException;

public class JwtExpiredException extends RveApplicationException {
  public JwtExpiredException() {
    super(ErrorCode.JWT_EXPIRED);
  }
}
