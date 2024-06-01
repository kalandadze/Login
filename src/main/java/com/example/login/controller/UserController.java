package com.example.login.controller;

import com.example.login.dto.UserDto;
import com.example.login.repository.exeption.UserNotFoundException;
import com.example.login.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        try {
            val response=service.getAllUsers();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> login(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            String uuid=service.login(password,email);
            return ResponseEntity.ok().body(uuid);
        }catch (UserNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        try {
            service.addUser(userDto);
            return ResponseEntity.status(201).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
