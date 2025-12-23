package com.example.hexagonal_rve.adapter.auth.in.out;

import com.example.hexagonal_rve.application.auth.spi.MailSenderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailSenderAdapter implements MailSenderPort {

  private final MailSender mailSender;

  @Override
  public void sendVerificationCode(String email, String code) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(email);
    message.setSubject("이메일 인증 코드");
    message.setText("인증 코드: " + code);
    mailSender.send(message);
  }
}
