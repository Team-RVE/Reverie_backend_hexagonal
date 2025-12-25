package com.example.hexagonal_rve.application.post.service;

import com.example.hexagonal_rve.application.post.port.in.ImageUseCase;
import com.example.hexagonal_rve.application.post.port.out.ImageRepository;
import com.example.hexagonal_rve.application.post.spi.ImageStoragePort;
import com.example.hexagonal_rve.domain.post.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService implements ImageUseCase {

  private final ImageStoragePort imageStoragePort;
  private final ImageRepository imageRepository;

  @Value("${cloud.aws.s3.bucket}")
  private String bucket;


  @Override
  public List<String> uploadImage(List<MultipartFile> file){
    List<String> uploadedUrls = imageStoragePort.upload(file);
    for (String url : uploadedUrls) {
      Image image = new Image(null,url);

      imageRepository.save(image);
    }
    return uploadedUrls;


  }

}
