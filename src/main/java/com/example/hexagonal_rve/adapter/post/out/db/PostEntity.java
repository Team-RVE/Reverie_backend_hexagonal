package com.example.hexagonal_rve.adapter.post.out.db;

import com.example.hexagonal_rve.adapter.post.out.db.image.ImageEntity;
import com.example.hexagonal_rve.domain.post.model.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class PostEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String title;
  private String content;
  @Enumerated(EnumType.STRING)
  private Category category;
  private LocalDateTime createdAt;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "post_id")
  private List<ImageEntity> images = new ArrayList<>();
  private boolean liked;

  public void addImage(ImageEntity image) {
    images.add(image);
  }

}
