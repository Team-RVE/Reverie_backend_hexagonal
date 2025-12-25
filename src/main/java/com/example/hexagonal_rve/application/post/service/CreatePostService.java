package com.example.hexagonal_rve.application.post.service;

import com.example.hexagonal_rve.application.post.port.in.CreatePostUseCase;
import com.example.hexagonal_rve.application.post.port.in.command.CreatePostCommand;
import com.example.hexagonal_rve.application.post.port.out.PostRepository;
import com.example.hexagonal_rve.domain.post.model.Image;
import com.example.hexagonal_rve.domain.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreatePostService implements CreatePostUseCase {

  private final PostRepository postRepository;

  @Override
  public void createPost(CreatePostCommand command) {
    Post post = Post.createNew(command.getTitle(),command.getContent(),command.getCategory());
    for(String url: command.getImageUrls()) {
      post.addImage(new Image(null,url));
    }
    postRepository.save(post);
  }


}
