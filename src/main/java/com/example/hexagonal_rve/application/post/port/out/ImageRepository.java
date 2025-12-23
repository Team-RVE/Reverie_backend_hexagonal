package com.example.hexagonal_rve.application.post.port.out;

import com.example.hexagonal_rve.domain.post.model.Image;

public interface ImageRepository {
  void save(Image image);
}
