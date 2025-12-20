package com.example.hexagonal_rve.adapter.post.out.minio;


import com.example.hexagonal_rve.application.post.exception.ImageIOException;
import com.example.hexagonal_rve.application.post.spi.ImageStoragePort;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
@Primary
@Service
@RequiredArgsConstructor
public class ImageStorageAdapter implements ImageStoragePort {

  private final MinioClient minioClient;

  @Value("${minio.bucket}")
  private String bucket;

  @Value("${minio.ip}")
  private String ip;

  @Override
  public List<String> upload(List<MultipartFile> files) {
    return files.stream().map(file -> {
      try {
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        minioClient.putObject(
            PutObjectArgs.builder()
                .bucket(bucket)
                .object(fileName)
                .stream(file.getInputStream(), file.getSize(), -1)
                .contentType(file.getContentType())
                .build()
        );

        return "http://" + ip + ":9000/" + bucket + "/" + fileName;

      } catch (Exception e) {
        throw new ImageIOException();
      }
    }).toList();
  }
}
