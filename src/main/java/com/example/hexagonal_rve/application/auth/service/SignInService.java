package com.example.hexagonal_rve.application.auth.service;

import com.example.hexagonal_rve.adapter.auth.in.dto.response.TokenResponse;
import com.example.hexagonal_rve.application.auth.exception.NotCorrectPassword;
import com.example.hexagonal_rve.application.auth.port.in.SignInUseCase;
import com.example.hexagonal_rve.application.auth.port.in.command.SignInCommand;
import com.example.hexagonal_rve.application.auth.port.out.JwtGeneratorPort;
import com.example.hexagonal_rve.application.user.exception.UserNotFoundException;
import com.example.hexagonal_rve.application.user.port.out.UserRepository;
import com.example.hexagonal_rve.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInService implements SignInUseCase {

  private final UserRepository userRepository;
  private final JwtGeneratorPort jwtGenerator;
  private final PasswordEncoder passwordEncoder;

  @Override
  public TokenResponse signIn(SignInCommand command) {

    User user = userRepository.findByEmail(command.getEmail()).orElseThrow(UserNotFoundException::new);

    if(!passwordEncoder.matches(command.getPassword(), user.getPassword())) {
      throw new NotCorrectPassword();
    }
    String accessToken = jwtGenerator.generateAccessToken(command.getEmail());
    String refreshToken = jwtGenerator.generateRefreshToken(command.getEmail());

    return TokenResponse.builder()
        .accessToken(accessToken)
        .refreshToken(refreshToken)
        .build();
  }
}
