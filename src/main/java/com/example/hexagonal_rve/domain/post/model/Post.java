package com.example.hexagonal_rve.domain.post.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Post {
  private final Integer id;
  private String title;
  private String content;
  private Category category;
  private final LocalDateTime createdAt;
  private List<String> imageUrls;
  private boolean liked;

  private Post(
      Integer id,
      String title,
      String content,
      Category category,
      LocalDateTime createdAt,
      List<String> imageUrls
  ) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.category = category;
    this.createdAt = createdAt;
    this.imageUrls = List.copyOf(imageUrls);
  }
  public static Post createNew(String title, String content, Category category, List<String> imageUrls) {
    return new Post(null, title, content, category, LocalDateTime.now(), imageUrls);
  }


  public static Post restore(
      Integer id,
      String title,
      String content,
      Category category,
      LocalDateTime createdAt,
      List<String> imageUrls) {
    return new Post(id, title, content, category, createdAt, imageUrls);

  }

  public void update(String title, String content, Category category, List<String> imageUrls) {
    this.title = title;
    this.content = content;
    this.category = category;
    this.imageUrls = List.copyOf(imageUrls);
  }

}
