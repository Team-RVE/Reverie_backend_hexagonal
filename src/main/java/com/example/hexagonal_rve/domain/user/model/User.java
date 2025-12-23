package com.example.hexagonal_rve.domain.user.model;

import lombok.Getter;

@Getter
public class User {
  private final Integer id;
  private final String email;
  private final String password;

  public static User create(String email, String password){
    return new User(null,email,password);
  }

  public static User restore(Integer id, String email, String password) {
    return new User(id,email,password);
  }
  public User(Integer id, String email, String password) {
    this.id = id;
    this.email = email;
    this.password = password;

  }
}
