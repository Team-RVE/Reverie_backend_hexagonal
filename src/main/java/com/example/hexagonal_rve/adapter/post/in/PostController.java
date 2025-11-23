package com.example.hexagonal_rve.adapter.post.in;

import com.example.hexagonal_rve.adapter.post.in.dto.CreatePostRequest;
import com.example.hexagonal_rve.adapter.post.in.dto.UpdatePostRequest;
import com.example.hexagonal_rve.application.post.port.in.CreatePostUseCase;
import com.example.hexagonal_rve.application.post.port.in.DeletePostUseCase;
import com.example.hexagonal_rve.application.post.port.in.ReadPostUseCase;
import com.example.hexagonal_rve.application.post.port.in.UpdatePostUseCase;
import com.example.hexagonal_rve.application.post.port.in.command.CreatePostCommand;
import com.example.hexagonal_rve.application.post.port.in.command.UpdatePostCommand;
import com.example.hexagonal_rve.domain.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
  private final CreatePostUseCase createPostUseCase;
  private final UpdatePostUseCase updatePostUseCase;
  private final DeletePostUseCase deletePostUseCase;
  private final ReadPostUseCase readPostUseCase;

  @PostMapping
  public void createPost(@RequestBody CreatePostRequest dto) {
    createPostUseCase.createPost(CreatePostCommand.builder()
        .title(dto.getTitle())
        .content(dto.getContent())
        .category(dto.getCategory())
        .build());
  }

  @GetMapping("/{id}")
  public Post getPosts(@PathVariable Integer id) {
    return readPostUseCase.readPostById(id);
  }

  @DeleteMapping("/{id}")
  public void deletePost(@PathVariable Integer id) {
    deletePostUseCase.deletePostById(id);
  }

  @PatchMapping
  public void updatePost(@RequestBody UpdatePostRequest dto) {
    updatePostUseCase.updatePost(UpdatePostCommand.builder()
        .id(dto.getId())
        .title(dto.getTitle())
        .content(dto.getContent())
        .category(dto.getCategory())
        .build());
  }
}
