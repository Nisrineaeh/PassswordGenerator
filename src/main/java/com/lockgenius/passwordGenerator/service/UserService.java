package com.lockgenius.passwordGenerator.service;

import com.lockgenius.passwordGenerator.Entities.UserEntity;
import com.lockgenius.passwordGenerator.Repositories.UserRepository;
import com.lockgenius.passwordGenerator.Utils.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;




    public UserEntity createUser(UserEntity user) {
        String hashedPassword = PasswordEncoder.hashPassword(user.getPasswordHash());
        user.setPasswordHash(hashedPassword);
        return userRepository.save(user);
    }
   /** public boolean checkPassword(String providedPassword, String storedHash) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(providedPassword, storedHash);
    }**/




}
