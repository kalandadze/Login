package com.example.login.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String username;
    private String email;
    private String privateNumber;
    private String password;
}
