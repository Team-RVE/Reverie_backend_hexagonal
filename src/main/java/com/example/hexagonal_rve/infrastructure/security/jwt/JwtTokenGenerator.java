package com.example.hexagonal_rve.infrastructure.security.jwt;

import com.example.hexagonal_rve.application.auth.spi.JwtGeneratorPort;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class JwtTokenGenerator implements JwtGeneratorPort {

  private final JwtProperties jwtProperties;
  private final RedisTemplate<String, String> redisTemplate;
  private final static String ACCESS_TOKEN="access_token";
  private final static String REFRESH_TOKEN="refresh_token";


  private SecretKey secretKey;

  @PostConstruct
  public void init() {
    this.secretKey = Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes(StandardCharsets.UTF_8));
  }

  SecretKey getSecretKey() {
    return secretKey;
  }

  @Override
  public String generateAccessToken(String email) {
    return generateToken(email,ACCESS_TOKEN, jwtProperties.getAccessTokenExpiresIn());
  }

  @Override
  public String generateRefreshToken(String email) {
    String refreshToken = generateToken(email,REFRESH_TOKEN, jwtProperties.getRefreshTokenExpiresIn());
    String key = REFRESH_TOKEN + email;
    redisTemplate.opsForValue().set(key,refreshToken,jwtProperties.getRefreshTokenExpiresIn(), TimeUnit.MILLISECONDS);
    return refreshToken;
  }

  private String generateToken(String email, String type,Long time){
    Date now = new Date();
    return Jwts.builder()
        .signWith(secretKey,SignatureAlgorithm.HS256)
        .claim("type",type)
        .setSubject(email)
        .setIssuedAt(now)
        .setExpiration(new Date(now.getTime()+time))
        .compact();
  }

}
