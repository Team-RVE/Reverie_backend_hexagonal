package com.example.hexagonal_rve.adapter.post.out.db;

import com.example.hexagonal_rve.adapter.post.out.db.image.ImageEntity;
import com.example.hexagonal_rve.domain.post.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper{

  public static Post toDomain(PostEntity entity){
    return Post.restore(
        entity.getId(),
        entity.getTitle(),
        entity.getContent(),
        entity.getCategory(),
        entity.getCreatedAt(),
        entity.getImages().stream()
            .map(ImageEntity::getImageUrl)
            .toList()
    );  }

  public static PostEntity toEntity(Post post){
    return PostEntity.builder()
        .title(post.getTitle())
        .content(post.getContent())
        .category(post.getCategory())
        .createdAt(post.getCreatedAt())
        .liked(post.isLiked())
        .build();
  }
}
