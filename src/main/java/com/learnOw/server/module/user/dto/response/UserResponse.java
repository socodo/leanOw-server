package com.learnOw.server.module.user.dto.response;

import java.time.LocalDateTime;

import com.learnOw.server.module.user.model.User.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String email;
    private String fullName;
    private String phone;
    private String avatarUrl;
    private String bio;
    private UserStatus status;
    private LocalDateTime createdAt;
}
