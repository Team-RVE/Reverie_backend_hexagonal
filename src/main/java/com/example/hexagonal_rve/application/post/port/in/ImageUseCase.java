package com.example.hexagonal_rve.application.post.port.in;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageUseCase {
  List<String> uploadImage(List<MultipartFile> file);
}
