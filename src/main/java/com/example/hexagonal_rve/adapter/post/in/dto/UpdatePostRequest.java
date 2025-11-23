package com.example.hexagonal_rve.adapter.post.in.dto;

import com.example.hexagonal_rve.domain.post.model.Category;
import lombok.Getter;

@Getter
public class UpdatePostRequest {
  private Integer id;
  private String title;
  private String content;
  private Category category;
}
