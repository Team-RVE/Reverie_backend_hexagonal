package com.example.hexagonal_rve.application.post.port.in;

import com.example.hexagonal_rve.application.post.port.in.command.CreatePostCommand;
import com.example.hexagonal_rve.domain.post.model.Post;

public interface CreatePostUseCase {
  void createPost(CreatePostCommand command);
}
