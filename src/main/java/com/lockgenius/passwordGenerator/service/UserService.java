package com.lockgenius.passwordGenerator.service;

import com.lockgenius.passwordGenerator.Entities.UserEntity;
import com.lockgenius.passwordGenerator.Repositories.UserRepository;
import com.lockgenius.passwordGenerator.Utils.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity user) {
        String hashedPassword = PasswordEncoder.hashPassword(user.getPasswordHash());
        user.setPasswordHash(hashedPassword);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsernameOrEmail(username, username);
        if (user == null) {
            System.out.println("Erreur au niveau du service");
            throw new UsernameNotFoundException("Utilisateur non trouvé avec le pseudo : " + username);
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPasswordHash(), new ArrayList<>());
    }
}
