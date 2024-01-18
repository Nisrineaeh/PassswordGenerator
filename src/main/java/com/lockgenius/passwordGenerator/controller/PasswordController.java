package com.lockgenius.passwordGenerator.controller;


import com.lockgenius.passwordGenerator.model.Password;

import com.lockgenius.passwordGenerator.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PasswordController {

    private final PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/generatePassword")
    public Password generatePassword() {
        String passwordStr = passwordService.generateRandomPassword(12);
        return new Password(passwordStr);
    }
}
