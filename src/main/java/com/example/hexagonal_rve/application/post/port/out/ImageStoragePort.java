package com.example.hexagonal_rve.application.post.port.out;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageStoragePort {
  List<String> upload(List<MultipartFile> file);
}
