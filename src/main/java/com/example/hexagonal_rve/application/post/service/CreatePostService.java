package com.example.hexagonal_rve.application.post.service;

import com.example.hexagonal_rve.application.post.port.in.CreatePostUseCase;
import com.example.hexagonal_rve.application.post.port.in.command.CreatePostCommand;
import com.example.hexagonal_rve.application.post.port.out.PostRepository;
import com.example.hexagonal_rve.domain.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreatePostService implements CreatePostUseCase {

  private final PostRepository postRepository;

  @Override
  public void createPost(CreatePostCommand command) {
    Post post = Post.builder()
        .title(command.getTitle())
        .content(command.getContent())
        .category(command.getCategory())
        .createdAt(LocalDateTime.now())
        .liked(false)
        .build();
    postRepository.save(post);
  }


}
