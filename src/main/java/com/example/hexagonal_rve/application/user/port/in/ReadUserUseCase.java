package com.example.hexagonal_rve.application.user.port.in;

import com.example.hexagonal_rve.domain.user.model.User;

import java.util.Optional;

public interface ReadUserUseCase {
  Optional<User> readUserById(Integer id);
}
