package com.lockgenius.passwordGenerator.controller;

import com.lockgenius.passwordGenerator.Entities.UserEntity;
import com.lockgenius.passwordGenerator.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lockgenius.passwordGenerator.Repositories.UserRepository;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {



    private final UserService UserService;
    private final UserRepository userRepository;

    public UserController(com.lockgenius.passwordGenerator.service.UserService userService, UserRepository userRepository) {
        UserService = userService;
        this.userRepository = userRepository;
    }


    @PostMapping("/auth/register")
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity user) {
            UserEntity registeredUser = UserService.createUser(user);
            return ResponseEntity.ok(registeredUser);

    }

    @GetMapping("/list")
    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users;
    }




}
