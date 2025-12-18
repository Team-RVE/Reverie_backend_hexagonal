package com.example.hexagonal_rve.application.auth.exception;

import com.example.hexagonal_rve.application.global.handler.ErrorCode;
import com.example.hexagonal_rve.application.global.handler.RveApplicationException;

public class AccountIdAlreadyExistsException extends RveApplicationException {
  public AccountIdAlreadyExistsException() {
    super(ErrorCode.ACCOUNT_ALREADY_EXISTS);
  }
}
