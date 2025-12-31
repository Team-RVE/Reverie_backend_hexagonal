package com.example.hexagonal_rve.domain.user.model;

import lombok.Getter;


@Getter
public class User {
  private final Integer id;
  private final String email;
  private final Role role;
  private final String password;

  public static User create(String email, String password,Role role) {
    return new User(null,email,password,role);
  }

  public static User restore(Integer id, String email, String password,Role role) {
    return new User(id,email,password,role);
  }

  public User(Integer id, String email, String password,Role role) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.role = role;

  }
}
