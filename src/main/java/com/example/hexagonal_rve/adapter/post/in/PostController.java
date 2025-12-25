package com.example.hexagonal_rve.adapter.post.in;

import com.example.hexagonal_rve.adapter.post.in.dto.CreatePostRequest;
import com.example.hexagonal_rve.adapter.post.in.dto.UpdatePostRequest;
import com.example.hexagonal_rve.application.post.port.in.*;
import com.example.hexagonal_rve.application.post.port.in.command.CreatePostCommand;
import com.example.hexagonal_rve.application.post.port.in.command.UpdatePostCommand;
import com.example.hexagonal_rve.domain.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

  private final CreatePostUseCase createPostUseCase;
  private final UpdatePostUseCase updatePostUseCase;
  private final DeletePostUseCase deletePostUseCase;
  private final ReadPostUseCase readPostUseCase;
  private final ImageUseCase imageUseCase;

  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public void createPost(@RequestPart("images") List<MultipartFile> images, @RequestPart("post") CreatePostRequest dto) {

    List<String> imageUrls = imageUseCase.uploadImage(images);

    createPostUseCase.createPost(CreatePostCommand.builder()
        .title(dto.getTitle())
        .content(dto.getContent())
        .category(dto.getCategory())
        .imageUrls(imageUrls)
        .build());
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Post getPosts(@PathVariable Integer id) {
    return readPostUseCase.readPostById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deletePost(@PathVariable Integer id) {
    deletePostUseCase.deletePostById(id);
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void updatePost(@PathVariable Integer id,@RequestPart("images")List<MultipartFile> images,@RequestPart("post") UpdatePostRequest dto) {

    List<String> imageUrls = imageUseCase.uploadImage(images);

    updatePostUseCase.updatePost(id,UpdatePostCommand.builder()
        .title(dto.getTitle())
        .content(dto.getContent())
        .category(dto.getCategory())
        .imageUrls(imageUrls)
        .build());
  }
  @PostMapping("/image")
  @ResponseStatus(HttpStatus.OK)
  public List<String> uploadImage(@RequestParam List<MultipartFile> files) {
    return imageUseCase.uploadImage(files);
  }
}
