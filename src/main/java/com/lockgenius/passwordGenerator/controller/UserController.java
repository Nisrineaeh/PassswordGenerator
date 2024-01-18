package com.lockgenius.passwordGenerator.controller;

import com.lockgenius.passwordGenerator.Entities.UserEntity;
import com.lockgenius.passwordGenerator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lockgenius.passwordGenerator.Repositories.UserRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class UserController {



        @Autowired
        private UserService UserService;


        @PostMapping("/register")
        public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity user) {
            UserEntity registeredUser = UserService.createUser(user);
            return ResponseEntity.ok(registeredUser);

    }

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;



   /** public String login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && userService.checkPassword(password, user.getPassword())) {
            // L'utilisateur est authentifié
        } else {
            // Échec de l'authentification
        }
        return username;
    }**/

}
