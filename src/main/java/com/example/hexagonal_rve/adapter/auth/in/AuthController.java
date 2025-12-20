package com.example.hexagonal_rve.adapter.auth.in;

import com.example.hexagonal_rve.adapter.auth.in.dto.request.*;
import com.example.hexagonal_rve.adapter.auth.in.dto.response.TokenResponse;
import com.example.hexagonal_rve.application.auth.port.in.ReissueUseCase;
import com.example.hexagonal_rve.application.auth.port.in.SetPasswordUseCase;
import com.example.hexagonal_rve.application.auth.port.in.SignInUseCase;
import com.example.hexagonal_rve.application.auth.port.in.SignUpUseCase;
import com.example.hexagonal_rve.application.auth.port.in.command.ReissueCommand;
import com.example.hexagonal_rve.application.auth.port.in.command.SetPasswordCommand;
import com.example.hexagonal_rve.application.auth.port.in.command.SignInCommand;
import com.example.hexagonal_rve.application.auth.port.in.command.VerifyCodeCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

  private final SignUpUseCase signUpUseCase;
  private final SetPasswordUseCase setPasswordUseCase;
  private final SignInUseCase signInUseCase;
  private final ReissueUseCase reissueUseCase;

  @PostMapping("/email/send")
  @ResponseStatus(HttpStatus.OK)
  public void sendCode(@RequestBody SendCodeRequest request) {
    signUpUseCase.sendCode(request.getEmail());
  }

  @PostMapping("/email/verify")
  @ResponseStatus(HttpStatus.OK)
  public void verifyCode(@RequestBody VerifyCodeRequest request) {
    signUpUseCase.verifyCode(VerifyCodeCommand.builder()
        .code(request.getCode())
        .email(request.getEmail())
        .build());
  }

  @PostMapping("/password/set")
  @ResponseStatus(HttpStatus.CREATED)
  public void setPassword(@RequestBody SetPasswordRequest request) {
    setPasswordUseCase.setPassword(SetPasswordCommand.builder()
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
