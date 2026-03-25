package com.learnOw.server.module.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.learnOw.server.module.auth.dto.request.RegisterRequest;
import com.learnOw.server.module.user.dto.response.UserResponse;
import com.learnOw.server.module.user.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userRoles", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "avatarUrl", ignore = true)
    @Mapping(target = "bio", ignore = true)
    @Mapping(target = "socialLinks", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "emailVerifiedAt", ignore = true)
    @Mapping(target = "failedLoginAttempts", ignore = true)
    @Mapping(target = "lockedUntil", ignore = true)
    @Mapping(target = "lastLoginAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    User toUser(RegisterRequest request);

    UserResponse toUserResponse(User user);
}
