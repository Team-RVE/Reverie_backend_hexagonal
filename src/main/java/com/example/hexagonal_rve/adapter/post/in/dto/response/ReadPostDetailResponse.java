package com.example.hexagonal_rve.adapter.post.in.dto.response;

import com.example.hexagonal_rve.domain.post.model.Category;
import com.example.hexagonal_rve.domain.post.model.Image;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ReadPostDetailResponse {

  private Integer id;
  private String title;
  private String content;
  private Category category;
  private LocalDateTime createdAt;
  private List<Image> images;
  private boolean liked;
}
