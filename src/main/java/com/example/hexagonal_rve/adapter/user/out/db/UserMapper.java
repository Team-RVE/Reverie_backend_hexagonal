package com.example.hexagonal_rve.adapter.user.out.db;

import com.example.hexagonal_rve.domain.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public static User toDomain(UserEntity entity){
    return User.restore(entity.getId(),entity.getEmail(),entity.getPassword(),entity.getRole());
  }

  public static UserEntity toEntity(User user){
    return UserEntity.builder()
        .email(user.getEmail())
        .password(user.getPassword())
        .build();


  }
}
