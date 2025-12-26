package com.example.hexagonal_rve.application.post.port.in;

import com.example.hexagonal_rve.adapter.auth.in.dto.response.ReadPostDetailResponse;
import com.example.hexagonal_rve.adapter.auth.in.dto.response.ReadPostResponse;
import com.example.hexagonal_rve.domain.post.model.Category;
import com.example.hexagonal_rve.domain.post.model.Post;

import java.util.List;

public interface ReadPostUseCase {
  ReadPostDetailResponse readPostById(Integer id);
  List<ReadPostResponse> readAllPosts();
  List<ReadPostResponse> readPostsByCategory(Category category);
}
