package com.example.hexagonal_rve.adapter.post.out.db;

import com.example.hexagonal_rve.domain.post.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaPostRepository extends JpaRepository<PostEntity, Integer> {
  List<PostEntity> findByLiked(boolean liked);
  List<PostEntity> findByCategory(Category category);
}
