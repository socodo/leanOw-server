package com.learnOw.server.module.auth.dto.request;

import lombok.Data;

@Data
public class IntrospectRequest {
  private String token;
}
