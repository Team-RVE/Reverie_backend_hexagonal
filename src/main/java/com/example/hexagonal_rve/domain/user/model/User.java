package com.example.hexagonal_rve.domain.user.model;

import com.example.hexagonal_rve.adapter.post.out.db.PostEntity;
import com.example.hexagonal_rve.adapter.user.out.db.UserEntity;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
  private int id;
  private String accountId;
  private String password;

  public static User restore(UserEntity userEntity){
    return User.builder()
        .accountId(userEntity.getAccountId())
        .password(userEntity.getPassword())
        .build();
  }
}
