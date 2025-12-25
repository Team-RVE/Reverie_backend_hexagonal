package com.example.hexagonal_rve.application.post.service;

import com.example.hexagonal_rve.application.post.port.in.ImageUseCase;
import com.example.hexagonal_rve.application.post.spi.ImageStoragePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService implements ImageUseCase {

  private final ImageStoragePort imageStoragePort;

  @Override
  public List<String> uploadImage(List<MultipartFile> file){
    return imageStoragePort.upload(file);
  }

}
