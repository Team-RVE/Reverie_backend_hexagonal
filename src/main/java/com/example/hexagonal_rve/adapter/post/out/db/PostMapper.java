package com.example.hexagonal_rve.adapter.post.out.db;

import com.example.hexagonal_rve.domain.post.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper{

  public Post toDomain(PostEntity postEntity){
    return Post.restore(postEntity);
  }

  public PostEntity toEntity(Post post){
    return PostEntity.builder()
        .title(post.getTitle())
        .content(post.getContent())
        .category(post.getCategory())
        .createdAt(post.getCreatedAt())
        .liked(post.isLiked())
        .build();
  }
}
