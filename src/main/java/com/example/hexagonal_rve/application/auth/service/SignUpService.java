package com.example.hexagonal_rve.application.auth.service;

import com.example.hexagonal_rve.application.auth.exception.EmailAlreadyExistsException;
import com.example.hexagonal_rve.application.auth.exception.EmailNotVerifiedException;
import com.example.hexagonal_rve.application.auth.port.in.SignUpUseCase;
import com.example.hexagonal_rve.application.auth.port.in.command.SignUpCommand;
import com.example.hexagonal_rve.application.auth.port.out.PendingUserRepository;
import com.example.hexagonal_rve.application.user.port.out.UserRepository;
import com.example.hexagonal_rve.domain.auth.vo.PendingStatus;
import com.example.hexagonal_rve.domain.auth.vo.PendingUser;
import com.example.hexagonal_rve.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService implements SignUpUseCase {

  private final UserRepository userRepository;
  private final PendingUserRepository pendingUserRepository;
  private final PasswordEncoder passwordEncoder;


  @Override
  public void signUp(SignUpCommand command) {

    if(userRepository.existsByEmail(command.getEmail())) {
      throw new EmailAlreadyExistsException();
    }

    PendingUser pendingUser= pendingUserRepository.findByEmail(command.getEmail());

    if(!pendingUser.isVerified(PendingStatus.EMAIL_VERIFIED)){
      throw new EmailNotVerifiedException();
    }

    String encodedPassword = passwordEncoder.encode(command.getPassword());

    User user = User.create(command.getEmail(),encodedPassword);

    userRepository.save(user);

    pendingUserRepository.deleteByEmail(command.getEmail());
  }
}
