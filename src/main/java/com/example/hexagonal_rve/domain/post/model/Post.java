package com.example.hexagonal_rve.domain.post.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Post {
  private final Integer id;
  private String title;
  private String content;
  private Category category;
  private final LocalDateTime createdAt;
  private List<Image> images;
  private boolean liked;

  private Post(
      Integer id,
      String title,
      String content,
      Category category,
      LocalDateTime createdAt,
      boolean liked,
      List<Image> images
  ) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.category = category;
    this.createdAt = createdAt;
    this.liked = liked;
    this.images = (images != null) ? images : new ArrayList<>();
  }

  public static Post createNew(String title, String content, Category category) {
    return new Post(null,title, content, category, LocalDateTime.now(),false,new ArrayList<>());
  }


  public static Post restore(
      Integer id,
      String title,
      String content,
      Category category,
      LocalDateTime createdAt,
      boolean liked,
      List<Image> images) {
    List<Image> imagesList = new ArrayList<>(images);
    return new Post (id,title, content, category, createdAt,liked,imagesList);

  }

  public void update(String title, String content, Category category) {
    this.title = title;
    this.content = content;
    this.category = category;
  }

  public void addImage(Image image) {
    images.add(image);
  }

  public void changeLikeStatus() {
    if(liked)
      liked = false;
    else
      liked = true;
  }

}
