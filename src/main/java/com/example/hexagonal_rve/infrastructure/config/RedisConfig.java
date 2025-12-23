package com.example.hexagonal_rve.infrastructure.config;

import com.example.hexagonal_rve.domain.auth.vo.PendingUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

  @Value("${redis.host}")
  private String redisHost;

  @Value("${redis.port}")
  private int redisPort;

  @Value("${redis.password}")
  private String redisPassword;

  @Bean
  public RedisConnectionFactory redisConnectionFactory() {
    RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
    redisStandaloneConfiguration.setHostName(redisHost);
    redisStandaloneConfiguration.setPort(redisPort);
    if (redisPassword != null && !redisPassword.isEmpty()) {
      redisStandaloneConfiguration.setPassword(redisPassword);
    }
    return new LettuceConnectionFactory(redisStandaloneConfiguration);
  }


  @Bean
  public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);

    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setHashKeySerializer(new StringRedisSerializer());

    return redisTemplate;
  }
  @Bean
  public RedisTemplate<String, PendingUser> pendingUserRedisTemplate(
      RedisConnectionFactory factory
  ) {
    RedisTemplate<String, PendingUser> template = new RedisTemplate<>();
    template.setConnectionFactory(factory);

    Jackson2JsonRedisSerializer<PendingUser> serializer =
        new Jackson2JsonRedisSerializer<>(PendingUser.class);

    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(serializer);

    return template;
  }
}
