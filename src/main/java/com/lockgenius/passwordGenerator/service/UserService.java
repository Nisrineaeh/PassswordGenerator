package com.lockgenius.passwordGenerator.service;

import com.lockgenius.passwordGenerator.Entities.UserEntity;
import com.lockgenius.passwordGenerator.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;




    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }


}
