package com.learnOw.server.module.auth.service;

import com.learnOw.server.exception.AppException;
import com.learnOw.server.exception.ErrorCode;
import com.learnOw.server.module.auth.dto.request.IntrospectRequest;
import com.learnOw.server.module.auth.dto.request.LoginRequest;
import com.learnOw.server.module.auth.dto.request.RegisterRequest;
import com.learnOw.server.module.auth.dto.response.AuthResponse;
import com.learnOw.server.module.auth.dto.response.IntrospectResponse;
import com.learnOw.server.module.user.dto.response.UserResponse;
import com.learnOw.server.module.user.mapper.UserMapper;
import com.learnOw.server.module.user.model.User;
import com.learnOw.server.module.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final UserMapper userMapper;

  public AuthResponse login(LoginRequest request) {
    User user =
        userRepository
            .findByEmail(request.getEmail())
            .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
    if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
      throw new AppException(ErrorCode.INVALID_PASSWORD);
    }

    var token = jwtService.generateToken(user);

    return AuthResponse.builder().token(token).authenticated(true).build();
  }

  public UserResponse register(RegisterRequest request) {
    if (userRepository.existsByEmail(request.getEmail())) {
      throw new AppException(ErrorCode.USER_EXISTED);
    }

    User user = userMapper.toUser(request);
    user.setPasswordHash(passwordEncoder.encode(request.getPassword()));

    user = userRepository.save(user);

    return userMapper.toUserResponse(user);
  }

  public IntrospectResponse introspect(IntrospectRequest request) {
    boolean isValid = jwtService.verifyToken(request.getToken());
    return IntrospectResponse.builder().valid(isValid).build();
  }
}
