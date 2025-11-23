package com.example.hexagonal_rve.application.post.exception;

import com.example.hexagonal_rve.application.global.handler.ErrorCode;
import com.example.hexagonal_rve.application.global.handler.RveException;

public class NotFoundPostException extends RveException {
  public NotFoundPostException() {
    super(ErrorCode.NOT_FOUND_POST);
  }
}
