package com.example.hexagonal_rve.application.global.handler;

import lombok.Getter;

@Getter
public class RveException extends RuntimeException {
  private final ErrorCode errorCode;

  public RveException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }
}
