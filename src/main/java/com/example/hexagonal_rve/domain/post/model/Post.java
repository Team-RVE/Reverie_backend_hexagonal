package com.example.hexagonal_rve.domain.post.model;

import com.example.hexagonal_rve.adapter.post.out.db.PostEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Post {
  private final Integer id;
  private final String title;
  private final String content;
  private final Category category;
  private final LocalDateTime createdAt;
  private final List<String> imageUrls;
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
    this.imageUrls = imageUrls;
  }
  public static Post createNew(String title, String content, Category category, List<String> imageUrls) {
    return new Post(null, title, content, category, LocalDateTime.now(), imageUrls);
  }


  public static Post restore(PostEntity entity) {
    List<String> urls = Image.restoreAll(entity.getImages())  // List<Image>
        .stream()
        .map(Image::getUrl)       // List<String>으로 변환
        .toList();
    return new Post(
        entity.getId(),
        entity.getTitle(),
        entity.getContent(),
        entity.getCategory(),
        entity.getCreatedAt(),
        urls
    );
  }

  public Post update(String title, String content, Category category,List<Image> images) {
    List<String>  urls=images.stream()
        .map(Image::getUrl)
        .toList();
    return new Post(
        this.id,
        title,
        content,
        category,
        this.createdAt,
        urls
    );
  }

}
