package com.example.hexagonal_rve.infrastructure.security.auth;

import com.example.hexagonal_rve.application.user.port.out.UserRepository;
import com.example.hexagonal_rve.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user =userRepository.findByEmail(email)
        .orElseThrow(()->new UsernameNotFoundException(email));
    return new CustomUserDetails(user);
  }
}
