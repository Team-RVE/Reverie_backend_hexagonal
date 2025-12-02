package com.example.hexagonal_rve.adapter.post.out.db;

import jakarta.persistence.*;

@Entity
@Table(name = "Image")
public class ImageEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String url;
}
