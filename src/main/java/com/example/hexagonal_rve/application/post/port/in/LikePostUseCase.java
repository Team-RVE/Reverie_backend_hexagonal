package com.example.hexagonal_rve.application.post.port.in;

import com.example.hexagonal_rve.adapter.post.in.dto.response.ReadPostResponse;

import java.util.List;

public interface LikePostUseCase {
  void changeLikeStatus(Integer id);
  List<ReadPostResponse> getLikedPosts();
}
