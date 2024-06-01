package com.example.login.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDtoCollection {
    private List<UserDto> users;
}
