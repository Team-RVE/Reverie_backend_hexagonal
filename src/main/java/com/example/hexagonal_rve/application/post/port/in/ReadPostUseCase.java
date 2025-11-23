package com.example.hexagonal_rve.application.post.port.in;

import com.example.hexagonal_rve.domain.post.model.Post;

import java.util.List;

public interface ReadPostUseCase {
  Post readPostById(Integer id);
  List<Post> readAllPosts();
}
