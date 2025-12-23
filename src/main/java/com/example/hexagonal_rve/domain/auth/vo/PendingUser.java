package com.example.hexagonal_rve.domain.auth.vo;

import com.example.hexagonal_rve.application.auth.exception.InvalidAuthenticationStatusException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PendingUser {
  private final String email;
  private final PendingStatus pendingStatus;
  private final String verificationCode;

  @JsonCreator
  private PendingUser(@JsonProperty("email") String email, @JsonProperty("pendingStatus") PendingStatus pendingStatus, @JsonProperty("verificationCode")String verificationCode) {
    this.email = email;
    this.pendingStatus = pendingStatus;
    this.verificationCode = verificationCode;
  }

  public static PendingUser create(String email,String verificationCode) {
    return new PendingUser(email, PendingStatus.CODE_SENT,verificationCode);
  }

  public PendingUser verifyEmail(){
    if(this.pendingStatus!=PendingStatus.CODE_SENT) {
      throw new InvalidAuthenticationStatusException();
    }
    return new PendingUser(email,PendingStatus.EMAIL_VERIFIED,null);
  }

  public boolean isVerified(PendingStatus status) {
    return this.pendingStatus==status;
  }
}

