package com.example.hexagonal_rve.application.post.port.in.command;

import com.example.hexagonal_rve.domain.post.model.Category;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatePostCommand {
  private String title;
  private String content;
  private Category category;
}
