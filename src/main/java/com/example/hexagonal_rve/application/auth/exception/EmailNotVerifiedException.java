package com.example.hexagonal_rve.application.auth.exception;

import com.example.hexagonal_rve.application.global.handler.ErrorCode;
import com.example.hexagonal_rve.application.global.handler.RveApplicationException;

public class EmailNotVerifiedException extends RveApplicationException {
  public EmailNotVerifiedException() {
    super(ErrorCode.NOT_VERIFIED_CODE);
  }
}
