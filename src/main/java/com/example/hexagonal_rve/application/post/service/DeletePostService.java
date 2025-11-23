package com.example.hexagonal_rve.application.post.service;

import com.example.hexagonal_rve.application.post.port.in.DeletePostUseCase;
import com.example.hexagonal_rve.application.post.port.out.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePostService implements DeletePostUseCase {

  private final PostRepository postRepository;

  @Override
  public void deletePostById(Integer id) {
    postRepository.deleteById(id);
  }
}
