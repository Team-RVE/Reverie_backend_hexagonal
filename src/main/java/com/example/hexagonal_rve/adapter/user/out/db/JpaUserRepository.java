package com.example.hexagonal_rve.adapter.user.out.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, Integer> {
  Optional<UserEntity> findByEmail(String accountId);
  boolean existsByEmail(String accountId);
}
