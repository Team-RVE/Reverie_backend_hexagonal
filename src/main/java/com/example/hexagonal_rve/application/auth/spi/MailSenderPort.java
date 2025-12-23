package com.example.hexagonal_rve.application.auth.spi;

public interface MailSenderPort {
  void sendVerificationCode(String email, String code);
}
