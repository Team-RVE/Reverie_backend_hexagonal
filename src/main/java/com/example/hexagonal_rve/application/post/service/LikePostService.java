package com.example.hexagonal_rve.application.post.service;

import com.example.hexagonal_rve.application.post.exception.NotFoundPostException;
import com.example.hexagonal_rve.application.post.port.in.LikePostUseCase;
import com.example.hexagonal_rve.application.post.port.out.PostRepository;
import com.example.hexagonal_rve.domain.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikePostService implements LikePostUseCase {

  private final PostRepository postRepository;

  @Override
  public void changeLikeStatus(Integer id) {
    Post post = postRepository.findById(id).orElseThrow(NotFoundPostException::new);

    post.changeLikeStatus();
    postRepository.save(post);
  }

  @Override
  public List<Post> getLikedPosts() {
    return postRepository.findByLikedPost();
  }
}
