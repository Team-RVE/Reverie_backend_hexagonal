package com.example.hexagonal_rve.application.auth.service;

import com.example.hexagonal_rve.application.auth.exception.AccountIdAlreadyExistsException;
import com.example.hexagonal_rve.application.auth.exception.NotCorrectCodeException;
import com.example.hexagonal_rve.application.auth.port.in.SignUpUseCase;
import com.example.hexagonal_rve.application.auth.port.in.command.VerifyCodeCommand;
import com.example.hexagonal_rve.application.user.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class SignUpService implements SignUpUseCase{
  private final UserRepository userRepository;
  private final JavaMailSender mailSender;
  private final RedisTemplate<String, String> redisTemplate;

  @Override
  public void sendCode(String email) {
    String code = generateCode();
    if(userRepository.existsByEmail(email)){
      throw new AccountIdAlreadyExistsException();
    }

    redisTemplate.opsForValue().set(email, code, 5, TimeUnit.MINUTES);
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(email);
    message.setSubject("이메일 인증 코드");
    message.setText("인증 코드: " + code);
    mailSender.send(message);
  }

  @Override
  public boolean verifyCode(VerifyCodeCommand command) {
    String saveCode = redisTemplate.opsForValue().get(command.getEmail());
    System.out.println(saveCode);
    if(saveCode == null){
      System.out.println("null save code");
      return false;
    }
    else if(saveCode.equals(command.getCode())){
      redisTemplate.opsForValue()
            .set("verified:"+command.getEmail(), "true",
              10, TimeUnit.MINUTES);
      return true;
    }
    throw new NotCorrectCodeException();
  }



  private String generateCode() {
    return String.valueOf((int) (Math.random() * 900_000) + 100_000);
  }
}
