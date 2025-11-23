package com.example.hexagonal_rve.application.post.port.in;

import com.example.hexagonal_rve.application.post.port.in.command.UpdatePostCommand;

public interface UpdatePostUseCase {
  void updatePost(UpdatePostCommand command);
}
