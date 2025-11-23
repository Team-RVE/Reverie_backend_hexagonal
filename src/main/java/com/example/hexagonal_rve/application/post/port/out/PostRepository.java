package com.example.hexagonal_rve.application.post.port.out;

import com.example.hexagonal_rve.domain.post.model.Post;

import java.util.Optional;

public interface PostRepository {
  void save(Post post);
  void deleteById(Integer id);
  Optional<Post> findById(Integer id);
  void update(Post post);

}
