package com.example.hexagonal_rve.application.auth.exception;

import com.example.hexagonal_rve.application.global.handler.ErrorCode;
import com.example.hexagonal_rve.application.global.handler.RveApplicationException;

public class NotFoundEmailCodeException extends RveApplicationException {
  public NotFoundEmailCodeException() {
    super(ErrorCode.NOT_FOUND_EMAIL_CODE);
  }
}
