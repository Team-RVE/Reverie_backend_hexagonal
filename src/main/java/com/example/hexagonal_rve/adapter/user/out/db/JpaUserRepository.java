package com.example.hexagonal_rve.adapter.user.out.db;

import com.example.hexagonal_rve.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, Integer> {
  Optional<User> findByEmail(String accountId);
  boolean existsByEmail(String accountId);
}
