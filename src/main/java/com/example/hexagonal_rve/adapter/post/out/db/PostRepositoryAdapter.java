package com.example.hexagonal_rve.adapter.post.out.db;

import com.example.hexagonal_rve.application.post.port.out.PostRepository;
import com.example.hexagonal_rve.domain.post.model.Post;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
@Transactional
public class PostRepositoryAdapter implements PostRepository {
  private final JpaPostRepository jpaPostRepository;
  private final PostMapper postMapper;


  @Override
  public void deleteById(Integer id) {
    jpaPostRepository.deleteById(id);
  }

  @Override
  public Optional<Post> findById(Integer id) {
    return jpaPostRepository.findById(id)
        .map(postMapper::toDomain);
  }

  @Override
  public void update(Post post) {

  }


  @Override
  public void save(Post post) {
    jpaPostRepository.save(postMapper.toEntity(post));
  }
}
