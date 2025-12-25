package com.example.hexagonal_rve.domain.post.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Post {
  private String title;
  private String content;
  private Category category;
  private final LocalDateTime createdAt;
  private List<Image> images;
  private boolean liked;

  private Post(
      String title,
      String content,
      Category category,
      LocalDateTime createdAt,
      List<Image> images
  ) {
    this.title = title;
    this.content = content;
    this.category = category;
    this.createdAt = createdAt;
    this.images = (images != null) ? images : new ArrayList<>();
  }

  public static Post createNew(String title, String content, Category category) {
    return new Post(title, content, category, LocalDateTime.now(),new ArrayList<>());
  }


  public static Post restore(
      String title,
      String content,
      Category category,
      LocalDateTime createdAt,
      List<Image> images) {
    return new Post (title, content, category, createdAt, images);

  }

  public void update(String title, String content, Category category, List<Image> images) {
    this.title = title;
    this.content = content;
    this.category = category;
    this.images = images;
  }

  public void addImage(Image image) {
    images.add(image);
  }

}
