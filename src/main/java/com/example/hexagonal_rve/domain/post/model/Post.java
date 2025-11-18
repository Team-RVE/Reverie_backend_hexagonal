package com.example.hexagonal_rve.domain.post.model;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
  private Integer id;
  private String title;
  private String content;
  private Category category;
  private LocalDateTime createdAt;
  private boolean liked;
  private List<Image> images;
}
