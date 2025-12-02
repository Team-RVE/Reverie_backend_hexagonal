package com.example.hexagonal_rve.adapter.user.out.db;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String accountId;
  private String password;
}
