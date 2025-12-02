package com.example.hexagonal_rve.application.global.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(RveException.class)
  public ResponseEntity<String> handleRveException(RveException e) {
    return ResponseEntity.status(e.getErrorCode().getHttpStatus()).body(e.getMessage());
  }
}
