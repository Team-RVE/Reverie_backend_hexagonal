package com.example.hexagonal_rve.domain.post.model;

import com.example.hexagonal_rve.adapter.post.out.db.ImageEntity;
import lombok.Getter;

import java.util.List;

@Getter
public class Image {
  private final Integer id;
  private final String url;

  public Image(Integer id, String url) {
    this.id = id;
    this.url = url;
  }

  public static Image restore(ImageEntity entity) {
    return new Image(
        entity.getId(),
        entity.getImageUrl()
    );
  }

  public static List<Image> restoreAll(List<ImageEntity> entities) {
    return entities.stream()
        .map(Image::restore)
        .toList();
  }


}
