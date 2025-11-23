package com.example.hexagonal_rve.application.post.port.in.command;

import com.example.hexagonal_rve.domain.post.model.Category;
import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Builder
@Getter
public class UpdatePostCommand {
  private Integer id;
  private String title;
  private String content;
  private Category category;
}
