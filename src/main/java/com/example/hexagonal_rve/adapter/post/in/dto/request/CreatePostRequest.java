package com.example.hexagonal_rve.adapter.post.in.dto.request;

import com.example.hexagonal_rve.domain.post.model.Category;
import lombok.Getter;

@Getter
public class CreatePostRequest {
  private String title;
  private String content;
  private Category category;
}
