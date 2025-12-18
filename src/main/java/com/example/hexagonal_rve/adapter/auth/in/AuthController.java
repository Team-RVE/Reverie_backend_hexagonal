package com.example.hexagonal_rve.adapter.auth.in;

import com.example.hexagonal_rve.adapter.auth.in.dto.request.SendCodeRequest;
import com.example.hexagonal_rve.adapter.auth.in.dto.request.SetPasswordRequest;
import com.example.hexagonal_rve.adapter.auth.in.dto.request.VerifyCodeRequest;
import com.example.hexagonal_rve.application.auth.port.in.SetPasswordUseCase;
import com.example.hexagonal_rve.application.auth.port.in.SignUpUseCase;
import com.example.hexagonal_rve.application.auth.port.in.command.SetPasswordCommand;
import com.example.hexagonal_rve.application.auth.port.in.command.VerifyCodeCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auths")
public class AuthController {
  private final SignUpUseCase signUpUseCase;
  private final SetPasswordUseCase setPasswordUseCase;

  @PostMapping("email/send")
  public void sendCode(@RequestBody SendCodeRequest request) {
    signUpUseCase.sendCode(request.getEmail());
  }

  @PostMapping("/email/verify")
  public boolean verifyCode(@RequestBody VerifyCodeRequest request) {
    return signUpUseCase.verifyCode(VerifyCodeCommand.builder()
        .code(request.getCode())
        .email(request.getEmail())
        .build());
  }

  @PostMapping("/password")
  public void setPassword(@RequestBody SetPasswordRequest request) {
    setPasswordUseCase.setPassword(SetPasswordCommand.builder()
        .email(request.getEmail())
        .password(request.getPassword())
        .build());
  }
}
