package com.example.hexagonal_rve.application.post.port.in.command;

import com.example.hexagonal_rve.domain.post.model.Category;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CreatePostCommand {
  private String title;
  private String content;
  private List<String> imageUrls;
  private Category category;
}
