package com.example.hexagonal_rve.application.post.port.in.command;

import com.example.hexagonal_rve.domain.post.model.Category;
import com.example.hexagonal_rve.domain.post.model.Image;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class UpdatePostCommand {
  private Integer id;
  private String title;
  private String content;
  private List<Image> images;
  private Category category;
}
