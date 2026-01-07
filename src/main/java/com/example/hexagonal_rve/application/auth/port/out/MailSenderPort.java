package com.example.hexagonal_rve.application.auth.port.out;

public interface MailSenderPort {
  void sendVerificationCode(String email, String code);
}
