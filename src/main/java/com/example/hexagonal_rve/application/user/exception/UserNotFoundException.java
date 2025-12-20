package com.example.hexagonal_rve.application.user.exception;

import com.example.hexagonal_rve.application.global.handler.ErrorCode;
import com.example.hexagonal_rve.application.global.handler.RveApplicationException;

public class UserNotFoundException extends RveApplicationException {
  public UserNotFoundException() {
    super(ErrorCode.USER_NOT_FOUND);
  }
}
