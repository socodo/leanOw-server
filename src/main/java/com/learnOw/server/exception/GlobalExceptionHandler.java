package com.learnOw.server.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learnOw.server.dto.response.ApiResponse;
import com.learnOw.server.dto.response.FieldError;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = AppException.class)
  ResponseEntity<ApiResponse> handlingAppException(AppException exception) {
    
        ApiResponse response = ApiResponse.builder()
        .code(exception.getErrorCode().getCode())
        .message(exception.getErrorCode().getMessage())
        .build();
    return ResponseEntity.status(exception.getErrorCode().getStatusCode()).body(response);
  }

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException exception){

    
    List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors().stream()
        .map(error -> FieldError.builder()
            .field(error.getField())
            .message(error.getDefaultMessage())
            .build())
        .collect(Collectors.toList());

    ApiResponse response = ApiResponse.builder()
        .code(ErrorCode.INVALID_INPUT.getCode())
        .message(ErrorCode.INVALID_INPUT.getMessage())
        .errors(fieldErrors)
        .build();

    return ResponseEntity.status(ErrorCode.INVALID_INPUT.getStatusCode()).body(response);
  }

  @ExceptionHandler(value = Exception.class)
  ResponseEntity<ApiResponse> handlingAppException(Exception exception) {
    ApiResponse response = ApiResponse.builder()

        .code(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode())
        .message(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage())
        .build();
    return ResponseEntity.status(ErrorCode.UNCATEGORIZED_EXCEPTION.getStatusCode()).body(response);
  }

}

