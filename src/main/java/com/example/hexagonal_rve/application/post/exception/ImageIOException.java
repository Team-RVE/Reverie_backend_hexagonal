package com.example.hexagonal_rve.application.post.exception;

import com.example.hexagonal_rve.application.global.handler.ErrorCode;
import com.example.hexagonal_rve.application.global.handler.RveApplicationException;

public class ImageIOException extends RveApplicationException {
  public ImageIOException() {
    super(ErrorCode.IMAGE_IO_EXCEPTION);
  }
}
