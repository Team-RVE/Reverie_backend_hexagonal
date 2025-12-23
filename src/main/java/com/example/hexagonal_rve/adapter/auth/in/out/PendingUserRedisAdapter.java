package com.example.hexagonal_rve.adapter.auth.in.out;

import com.example.hexagonal_rve.application.auth.port.out.PendingUserRepository;
import com.example.hexagonal_rve.domain.auth.vo.PendingUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class PendingUserRedisAdapter implements PendingUserRepository {

  private static final Duration TTL = Duration.ofMinutes(10);

  private final RedisTemplate<String, PendingUser> redisTemplate;

  @Override
  public void save(PendingUser pendingUser) {
    redisTemplate.opsForValue().set(key(pendingUser.getEmail()), pendingUser,TTL);
  }

  @Override
  public PendingUser findByEmail(String email) {
    return redisTemplate.opsForValue().get(key(email));
  }

  @Override
  public void update(PendingUser pendingUser) {
    redisTemplate.opsForValue().set(key(pendingUser.getEmail()), pendingUser,TTL);
  }

  @Override
  public void deleteByEmail(String email) {
    redisTemplate.delete(key(email));
  }

  private String key(String email) {
    return "pendingUser:" + email;
  }
}
