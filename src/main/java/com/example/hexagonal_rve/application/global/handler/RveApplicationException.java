package com.example.hexagonal_rve.application.global.handler;

import lombok.Getter;

@Getter
public class RveApplicationException extends RuntimeException {
  private final ErrorCode errorCode;

  public RveApplicationException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }
}
