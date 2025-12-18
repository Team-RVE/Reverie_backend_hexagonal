package com.example.hexagonal_rve.application.auth.service;

import com.example.hexagonal_rve.application.auth.exception.EmailNotVerifiedException;
import com.example.hexagonal_rve.application.auth.port.in.SetPasswordUseCase;
import com.example.hexagonal_rve.application.auth.port.in.command.SetPasswordCommand;
import com.example.hexagonal_rve.application.user.port.out.UserRepository;
import com.example.hexagonal_rve.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetPasswordService implements SetPasswordUseCase {

  private final UserRepository userRepository;
  private final RedisTemplate<String, String> redisTemplate;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void setPassword(SetPasswordCommand command) {
    String email =command.getEmail();
    String password = command.getPassword();

    String verifiedKey = "verified:" + email;
    String verified = redisTemplate.opsForValue().get(verifiedKey);

    if(!"true".equals(verified)) {
      throw new EmailNotVerifiedException();
    }
    String encodedPassword = passwordEncoder.encode(password);

    userRepository.save(User.builder()
    .email(email)
    .password(encodedPassword)
    .build());
  }
}
