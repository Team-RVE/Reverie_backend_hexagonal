package com.example.hexagonal_rve.adapter.user.out.db;

import com.example.hexagonal_rve.domain.user.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "user")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String email;
  private String password;
  private Role role;
}
