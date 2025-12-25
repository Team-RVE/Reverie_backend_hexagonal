package com.example.hexagonal_rve.domain.post.model;

import lombok.Getter;

@Getter
public class Image {
  private final Integer id;
  private final String url;

  public Image(Integer id, String url) {
    this.id = id;
    this.url = url;
  }

  public static Image restore(Integer id, String url) {
    return new Image(id, url);
  }
}
