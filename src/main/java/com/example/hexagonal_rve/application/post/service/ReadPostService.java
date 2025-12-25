package com.example.hexagonal_rve.application.post.service;

import com.example.hexagonal_rve.application.post.exception.NotFoundPostException;
import com.example.hexagonal_rve.application.post.port.in.ReadPostUseCase;
import com.example.hexagonal_rve.application.post.port.out.PostRepository;
import com.example.hexagonal_rve.domain.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadPostService implements ReadPostUseCase {

  private final PostRepository postRepository;
  @Override
  public Post readPostById(Integer id) {
    return postRepository.findById(id)
        .orElseThrow(NotFoundPostException::new);
  }

  @Override
  public List<Post> readAllPosts() {
    return List.of();
  }
}
