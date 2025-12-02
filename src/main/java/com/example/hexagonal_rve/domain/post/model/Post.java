package com.example.hexagonal_rve.domain.post.model;

import com.example.hexagonal_rve.adapter.post.out.db.PostEntity;
import com.example.hexagonal_rve.application.post.port.in.command.UpdatePostCommand;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Post {
  private Integer id;
  private String title;
  private String content;
  private Category category;
  private LocalDateTime createdAt;
  private boolean liked;

  public static Post restore(PostEntity postEntity) {
    return Post.builder()
        .title(postEntity.getTitle())
        .content(postEntity.getContent())
        .category(postEntity.getCategory())
        .createdAt(postEntity.getCreatedAt())
        .liked(postEntity.isLiked())
        .build();
  }

  public Post updatePost(UpdatePostCommand command) {
    this.title = command.getTitle();
    this.content = command.getContent();
    this.category = command.getCategory();
    return this;
  }
}
