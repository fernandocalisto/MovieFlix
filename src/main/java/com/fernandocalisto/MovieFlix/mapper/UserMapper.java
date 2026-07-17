package com.fernandocalisto.MovieFlix.mapper;

import com.fernandocalisto.MovieFlix.controller.request.UserRequest;
import com.fernandocalisto.MovieFlix.controller.response.UserResponse;
import com.fernandocalisto.MovieFlix.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request) {
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

}
