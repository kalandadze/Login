package com.example.login.util;

import com.example.login.dto.UserDto;
import com.example.login.dto.UserDtoCollection;
import com.example.login.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModelConverter {
    public UserDto convert(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .privateNumber(user.getPrivateNumber())
                .username(user.getUsername()).build();
    }

    public User convert(UserDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .privateNumber(userDto.getPrivateNumber())
                .username(userDto.getUsername())
                .build();
    }

    public UserDtoCollection convert(List<User> users) {
        return UserDtoCollection.builder()
                .users(users.stream().map(this::convert).toList())
                .build();
    }
}
