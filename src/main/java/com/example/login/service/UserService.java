package com.example.login.service;

import com.example.login.dto.UserDto;
import com.example.login.dto.UserDtoCollection;
import com.example.login.repository.UserRepository;
import com.example.login.repository.exeption.UserNotFoundException;
import com.example.login.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    UserRepository repository;
    ModelConverter converter;

    @Autowired
    public UserService(UserRepository repository, ModelConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public UserDtoCollection getAllUsers() {
        return converter.convert(repository.findAll());
    }

    public void addUser(UserDto userDto) {
        repository.save(converter.convert(userDto));
    }

    public String login(String password, String email) {
        repository.findByEmailAndPassword(email, password).orElseThrow(UserNotFoundException::new);
        return UUID.randomUUID().toString();
    }
}
