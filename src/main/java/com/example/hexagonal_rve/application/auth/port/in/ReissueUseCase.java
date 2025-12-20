package com.example.hexagonal_rve.application.auth.port.in;

import com.example.hexagonal_rve.adapter.auth.in.dto.response.TokenResponse;
import com.example.hexagonal_rve.application.auth.port.in.command.ReissueCommand;

public interface ReissueUseCase {
  TokenResponse reissue(ReissueCommand command);
}
