package com.example.hexagonal_rve.adapter.auth.in;

import com.example.hexagonal_rve.adapter.auth.in.dto.request.*;
import com.example.hexagonal_rve.adapter.auth.in.dto.response.TokenResponse;
import com.example.hexagonal_rve.application.auth.port.in.*;
import com.example.hexagonal_rve.application.auth.port.in.command.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

  private final EmailVerificationUseCase emailVerificationUseCase;
  private final SignInUseCase signInUseCase;
  private final ReissueUseCase reissueUseCase;
  private final SignUpUseCase signUpUseCase;

  @PostMapping("/email/send")
  @ResponseStatus(HttpStatus.OK)
  public void sendCode(@RequestBody SendCodeRequest request) {
    emailVerificationUseCase.sendCode(request.getEmail());
  }

  @PostMapping("/email/verify")
  @ResponseStatus(HttpStatus.OK)
  public void verifyCode(@RequestBody VerifyCodeRequest request) {
    emailVerificationUseCase.verifyCode(VerifyCodeCommand.builder()
        .code(request.getCode())
        .email(request.getEmail())
        .build());
  }

  @PostMapping("/sign-up")
  @ResponseStatus(HttpStatus.CREATED)
  public void signUp(@RequestBody SignUpRequest request) {
    signUpUseCase.signUp(SignUpCommand.builder()
        .email(request.getEmail())
        .password(request.getPassword())
        .build());
  }

  @PostMapping("/sign-in")
  @ResponseStatus(HttpStatus.OK)
  public TokenResponse signIn(@RequestBody LoginRequest request) {
    return signInUseCase.signIn(SignInCommand.builder()
        .email(request.getEmail())
        .password(request.getPassword())
        .build());
  }

  @PostMapping("/reissue")
  @ResponseStatus(HttpStatus.OK)
  public TokenResponse reissue(@RequestBody ReissueRequest request) {
    return reissueUseCase.reissue(ReissueCommand.builder()
        .email(request.getEmail())
        .refreshToken(request.getRefreshToken())
        .build());
  }
}
