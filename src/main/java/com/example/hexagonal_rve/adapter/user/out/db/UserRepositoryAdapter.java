package com.example.hexagonal_rve.adapter.user.out.db;

import com.example.hexagonal_rve.adapter.post.out.db.JpaPostRepository;
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
  public Optional<User> findById(Integer id) {
    return jpaUserRepository.findById(id)
        .map(userMapper::toDomain);
  }
  @Override
  public Optional<User> findByAccountId(String accountId) {
    return jpaUserRepository.findByAccountId(accountId);
  }
}
