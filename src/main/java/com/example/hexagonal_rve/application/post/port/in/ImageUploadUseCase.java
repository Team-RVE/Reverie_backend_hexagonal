package com.example.hexagonal_rve.application.post.port.in;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadUseCase {
  String uploadImage(MultipartFile file);
}
