package com.example.hexagonal_rve.application.user.port.out;

import com.example.hexagonal_rve.domain.user.model.User;

import java.util.Optional;

public interface UserRepository {
  Optional<User> findById(Integer id);
  Optional<User> findByAccountId(String accountId);

}
