package com.example.hexagonal_rve.adapter.auth.in.dto.response;

import com.example.hexagonal_rve.domain.post.model.Category;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReadPostResponse {

  private String title;
  private String content;
  private Category category;
  private LocalDateTime createdAt;
}
