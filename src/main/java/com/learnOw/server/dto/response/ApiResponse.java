package com.learnOw.server.dto.response;

import java.util.List;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse<T> {

  @Builder.Default
  private int code = 1000;
  private String message;
  private T result;
  private List<FieldError> errors;

}
