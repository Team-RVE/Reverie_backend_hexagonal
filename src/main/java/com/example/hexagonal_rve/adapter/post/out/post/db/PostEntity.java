package com.example.hexagonal_rve.adapter.post.out.post.db;

import com.example.hexagonal_rve.domain.post.model.Category;
import com.example.hexagonal_rve.domain.post.model.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.time.LocalDateTime;

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
  private boolean liked;

}
