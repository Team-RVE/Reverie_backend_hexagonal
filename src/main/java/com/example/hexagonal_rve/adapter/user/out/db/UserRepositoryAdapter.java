package com.example.hexagonal_rve.adapter.user.out.db;

import com.example.hexagonal_rve.application.user.port.out.UserRepository;
import com.example.hexagonal_rve.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {


  private final JpaUserRepository jpaUserRepository;
  private final UserMapper userMapper;

  @Override
  public Optional<User> findByEmail(String email) {
    return jpaUserRepository.findByEmail(email);
  }

  @Override
  public boolean existsByEmail(String email) {
    return jpaUserRepository.existsByEmail(email);
  }

  @Override
  public void save(User user) {
    jpaUserRepository.save(userMapper.toEntity(user));
  }
}
