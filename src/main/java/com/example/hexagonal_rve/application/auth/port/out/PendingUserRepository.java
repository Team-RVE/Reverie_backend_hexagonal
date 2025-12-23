package com.example.hexagonal_rve.application.auth.port.out;

import com.example.hexagonal_rve.domain.auth.vo.PendingUser;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.print.DocFlavor;

public interface PendingUserRepository {
  void save(PendingUser pendingUser);
  PendingUser findByEmail(String email);
  void update(PendingUser pendingUser);
  void deleteByEmail(String email);

}
