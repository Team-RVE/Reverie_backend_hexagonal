package com.example.hexagonal_rve.application.global.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  NOT_FOUND_POST(HttpStatus.NOT_FOUND,"can not find post"),
  JWT_EXPIRED(HttpStatus.UNAUTHORIZED,"token is expired"),
  JWT_INVALID(HttpStatus.UNAUTHORIZED,"token is invalid"),
  JWT_NOT_FOUND(HttpStatus.UNAUTHORIZED,"token not found"),
  ACCOUNT_ALREADY_EXISTS(HttpStatus.CONFLICT,"account already exists"),
  NOT_CORRECT_CODE(HttpStatus.UNAUTHORIZED,"not correct code"),
  NOT_VERIFIED_CODE(HttpStatus.UNAUTHORIZED,"not verified code"),
  NOT_FOUND_EMAIL_CODE(HttpStatus.NOT_FOUND,"email code not found");

  private final HttpStatus httpStatus;
  private final String message;
}
