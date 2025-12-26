package com.example.hexagonal_rve.application.post.service;

import com.example.hexagonal_rve.adapter.post.in.dto.response.ReadPostDetailResponse;
import com.example.hexagonal_rve.adapter.post.in.dto.response.ReadPostResponse;
import com.example.hexagonal_rve.application.post.exception.NotFoundPostException;
import com.example.hexagonal_rve.application.post.port.in.ReadPostUseCase;
import com.example.hexagonal_rve.application.post.port.out.PostRepository;
import com.example.hexagonal_rve.domain.post.model.Category;
import com.example.hexagonal_rve.domain.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadPostService implements ReadPostUseCase {
  private final PostRepository postRepository;
  @Override
  public ReadPostDetailResponse readPostById(Integer id) {
    Post post = postRepository.findById(id)
        .orElseThrow(NotFoundPostException::new);

    return ReadPostDetailResponse.builder()
        .title(post.getTitle())
        .content(post.getContent())
        .category(post.getCategory())
        .createdAt(post.getCreatedAt())
        .images(post.getImages())
        .liked(post.isLiked())
        .build();
  }

  @Override
  public List<ReadPostResponse> readAllPosts() {
    List<Post> posts = postRepository.findAll();

    return posts.stream()
        .map(post -> ReadPostResponse.builder()
            .title(post.getTitle())
            .content(post.getContent())
            .category(post.getCategory())
            .createdAt(post.getCreatedAt())
            .build()
        )
        .toList();
  }

  @Override
  public List<ReadPostResponse> readPostsByCategory(Category category) {
    List<Post> posts = postRepository.findByCategory(category);

    return posts.stream()
        .map(post -> ReadPostResponse.builder()
            .title(post.getTitle())
            .content(post.getContent())
            .category(post.getCategory())
            .createdAt(post.getCreatedAt())
            .build()
        )
        .toList();
  }
}
