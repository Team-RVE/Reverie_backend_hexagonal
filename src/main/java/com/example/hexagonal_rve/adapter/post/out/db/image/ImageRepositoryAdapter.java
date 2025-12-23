package com.example.hexagonal_rve.adapter.post.out.db.image;

import com.example.hexagonal_rve.application.post.port.out.ImageRepository;
import com.example.hexagonal_rve.domain.post.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ImageRepositoryAdapter implements ImageRepository {

  private final JpaImageRepository jpaImageRepository;

  @Override
  public void save(Image image) {
  }
}
