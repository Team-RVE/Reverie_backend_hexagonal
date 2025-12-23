package com.example.hexagonal_rve.adapter.post.out.db;

import com.example.hexagonal_rve.application.post.port.out.PostRepository;
import com.example.hexagonal_rve.domain.post.model.Post;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
@Transactional
public class PostRepositoryAdapter implements PostRepository {
  private final JpaPostRepository jpaPostRepository;


  @Override
  public void deleteById(Integer id) {
    jpaPostRepository.deleteById(id);
  }

  @Override
  public Optional<Post> findById(Integer id) {
    return jpaPostRepository.findById(id)
        .map(PostMapper::toDomain);
  }

  @Override
  public void save(Post post) {
    jpaPostRepository.save(PostMapper.toEntity(post));
  }
}
