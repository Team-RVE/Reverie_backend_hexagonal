package com.example.hexagonal_rve.application.auth.exception;

import com.example.hexagonal_rve.application.global.handler.ErrorCode;
import com.example.hexagonal_rve.application.global.handler.RveApplicationException;

public class NotFoundPendingUserException extends RveApplicationException {
  public NotFoundPendingUserException() {
    super(ErrorCode.NOT_FOUND_PENDING_USER);
  }
}
