package com.example.hexagonal_rve.adapter.post.out.db.image;

import com.example.hexagonal_rve.domain.post.model.Image;

public class ImageMapper {

  public static Image toDomain(ImageEntity entity){
    return Image.restore(entity.getId(),entity.getImageUrl());
  }

  public static ImageEntity toEntity(Image image){
    return ImageEntity.builder()
        .id(image.getId())
        .imageUrl(image.getUrl())
        .build();
  }
}
