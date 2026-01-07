package com.example.hexagonal_rve.application.auth.service;

import com.example.hexagonal_rve.adapter.auth.in.dto.response.TokenResponse;
import com.example.hexagonal_rve.application.auth.port.in.ReissueUseCase;
import com.example.hexagonal_rve.application.auth.port.in.command.ReissueCommand;
import com.example.hexagonal_rve.application.auth.port.out.JwtManagerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReissueService implements ReissueUseCase {

  private final JwtManagerPort jwtManager;


  @Override
  public TokenResponse reissue(ReissueCommand command) {

    String accessToken = jwtManager.reissueAccessToken(command.getEmail(), command.getRefreshToken());
    String refreshToken = command.getRefreshToken();

    return TokenResponse.builder()
        .accessToken(accessToken)
        .refreshToken(refreshToken)
        .build();
  }
}
