package com.example.hexagonal_rve.adapter.post.out.db;

import com.example.hexagonal_rve.adapter.post.out.db.image.ImageMapper;
import com.example.hexagonal_rve.domain.post.model.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PostMapper{

  public static Post toDomain(PostEntity entity){
    return Post.restore(
        entity.getId(),
        entity.getTitle(),
        entity.getContent(),
        entity.getCategory(),
        entity.getCreatedAt(),
        entity.isLiked(),
        entity.getImages().stream()
            .map(ImageMapper::toDomain)
            .toList());

    }

  public static PostEntity toEntity(Post post){
    PostEntity entity=PostEntity.builder()
        .id(post.getId())
        .title(post.getTitle())
        .content(post.getContent())
        .category(post.getCategory())
        .createdAt(post.getCreatedAt())
        .images(new ArrayList<>())
        .liked(post.isLiked())
        .build();

    if (post.getImages() != null) {
      post.getImages().stream()
          .map(ImageMapper::toEntity)
          .forEach(entity::addImage);
    }
    return entity;
  }

}
