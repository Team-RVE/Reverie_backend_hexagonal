package com.example.hexagonal_rve.application.post.service;

import com.example.hexagonal_rve.application.post.exception.NotFoundPostException;
import com.example.hexagonal_rve.application.post.port.in.UpdatePostUseCase;
import com.example.hexagonal_rve.application.post.port.in.command.UpdatePostCommand;
import com.example.hexagonal_rve.application.post.port.out.PostRepository;
import com.example.hexagonal_rve.domain.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePostService implements UpdatePostUseCase {

  private final PostRepository postRepository;

  @Override
  public void updatePost(UpdatePostCommand command) {
    Post post = postRepository.findById(command.getId())
        .orElseThrow(NotFoundPostException::new);

    postRepository.save(post.update(command.getTitle(), command.getContent(),command.getCategory(),command.getImages()));
  }


}
