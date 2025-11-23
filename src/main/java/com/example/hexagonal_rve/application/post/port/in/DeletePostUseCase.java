package com.example.hexagonal_rve.application.post.port.in;

import com.example.hexagonal_rve.domain.post.model.Post;

public interface DeletePostUseCase {
  void deletePostById(Integer id);
}
