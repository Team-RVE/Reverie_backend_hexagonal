package com.example.hexagonal_rve.adapter.post.out.db.image;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Image")
public class ImageEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String imageUrl;
}
