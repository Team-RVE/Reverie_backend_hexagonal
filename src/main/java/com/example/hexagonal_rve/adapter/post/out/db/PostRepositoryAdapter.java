package com.example.hexagonal_rve.adapter.post.out.db;

import com.example.hexagonal_rve.application.post.port.out.PostRepository;
import com.example.hexagonal_rve.domain.post.model.Category;
import com.example.hexagonal_rve.domain.post.model.Post;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
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

  @Override
  public List<Post> findAll() {
    List<PostEntity> postEntities = jpaPostRepository.findAll();

    return postEntities.stream()
        .map(PostMapper::toDomain)
        .toList();
  }

  @Override
  public List<Post> findByLikedPost() {
    List<PostEntity> liked = jpaPostRepository.findByLiked(true);
    return liked.stream().map(PostMapper::toDomain)
        .toList();
  }

  @Override
  public List<Post> findByCategory(Category category) {
    List<PostEntity> postEntities = jpaPostRepository.findByCategory(category);

    return postEntities.stream().map(PostMapper::toDomain).toList();
  }
}
