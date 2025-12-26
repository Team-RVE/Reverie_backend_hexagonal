package com.example.hexagonal_rve.adapter.post.out.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaPostRepository extends JpaRepository<PostEntity, Integer> {
  List<PostEntity> findByLiked(boolean liked);
}
