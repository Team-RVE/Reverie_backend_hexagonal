package com.example.hexagonal_rve.adapter.post.in.dto;

import com.example.hexagonal_rve.domain.post.model.Category;
import lombok.Getter;

import java.util.List;

@Getter
public class CreatePostRequest {
  private String title;
  private String content;
  private Category category;
  private List<String> imageUrls;
}
