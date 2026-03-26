package com.learnOw.server.module.auth.controller;

import com.learnOw.server.dto.response.ApiResponse;
import com.learnOw.server.module.auth.dto.request.IntrospectRequest;
import com.learnOw.server.module.auth.dto.request.LoginRequest;
import com.learnOw.server.module.auth.dto.request.RegisterRequest;
import com.learnOw.server.module.auth.dto.response.AuthResponse;
import com.learnOw.server.module.auth.dto.response.IntrospectResponse;
import com.learnOw.server.module.auth.service.AuthService;
import com.learnOw.server.module.user.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Auth Controller", description = "Các API liên quan đến xác thực")
public class AuthController {

  private final AuthService authService;

  @Operation(summary = "Đăng nhập", description = "API cho phép người dùng đăng nhập")
  @PostMapping("/login")
  public ApiResponse<AuthResponse> login(@RequestBody @Valid LoginRequest request) {
    return ApiResponse.<AuthResponse>builder()
        .code(1000)
        .message("Đăng nhập thành công")
        .result(authService.login(request))
        .build();
  }

  @Operation(summary = "Đăng ký tài khoản", description = "API cho phép học viên đăng ký tài khoản mới")
  @PostMapping("/register")
  public ApiResponse<UserResponse> register(@RequestBody @Valid RegisterRequest request) {
    return ApiResponse.<UserResponse>builder()
        .code(1000)
        .message("Đăng ký thành công")
        .result(authService.register(request))
        .build();
  }

  @Operation(summary = "Kiểm tra token", description = "API kiểm tra token có hợp lệ không")
  @PostMapping("/introspect")
  public ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request) {
    return ApiResponse.<IntrospectResponse>builder()
        .code(1000)
        .result(authService.introspect(request))
        .build();
  }
}
