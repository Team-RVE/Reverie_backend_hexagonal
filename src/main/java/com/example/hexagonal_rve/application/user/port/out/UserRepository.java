package com.example.hexagonal_rve.application.user.port.out;

import com.example.hexagonal_rve.domain.user.model.User;

import java.util.Optional;

public interface UserRepository {
  Optional<User> findByEmail(String email);
  boolean existsByEmail(String email);
  void save(User user);
}
