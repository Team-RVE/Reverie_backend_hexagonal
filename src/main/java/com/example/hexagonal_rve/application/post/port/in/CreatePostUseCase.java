package com.example.hexagonal_rve.application.post.port.in;

import com.example.hexagonal_rve.application.post.port.in.command.CreatePostCommand;

public interface CreatePostUseCase {
  void createPost(CreatePostCommand command);
}
