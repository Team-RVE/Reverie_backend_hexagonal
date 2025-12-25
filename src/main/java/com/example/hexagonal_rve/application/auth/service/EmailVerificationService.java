package com.example.hexagonal_rve.application.auth.service;

import com.example.hexagonal_rve.application.auth.exception.NotCorrectCodeException;
import com.example.hexagonal_rve.application.auth.exception.NotFoundPendingUserException;
import com.example.hexagonal_rve.application.auth.port.in.EmailVerificationUseCase;
import com.example.hexagonal_rve.application.auth.port.in.command.VerifyCodeCommand;
import com.example.hexagonal_rve.application.auth.port.out.PendingUserRepository;
import com.example.hexagonal_rve.application.auth.spi.MailSenderPort;
import com.example.hexagonal_rve.domain.auth.vo.PendingUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailVerificationService implements EmailVerificationUseCase {

  private final PendingUserRepository pendingUserRepository;
  private final MailSenderPort mailSender;

  @Override
  public void sendCode(String email) {
    String code = generateCode();

    pendingUserRepository.save(PendingUser.create(email,code));
    mailSender.sendVerificationCode(email,code);
  }

  @Override
  public void verifyCode(VerifyCodeCommand command) {
    PendingUser pendingUser = pendingUserRepository.findByEmail(command.getEmail());
    if(pendingUser == null) {
      throw new NotFoundPendingUserException();
    }
    if(!pendingUser.getVerificationCode().equals(command.getCode())) {
      throw new NotCorrectCodeException();
    }
    PendingUser verifiedUser = pendingUser.verifyEmail();

    pendingUserRepository.save(verifiedUser);
  }

  private String generateCode() {
    return String.valueOf((int) (Math.random() * 900_000) + 100_000);
  }
}
