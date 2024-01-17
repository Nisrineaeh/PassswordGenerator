package com.lockgenius.passwordGenerator.Entities;

import com.lockgenius.passwordGenerator.model.Password;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(name = "password_hash", nullable = false)
        private String passwordHash;

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Password> passwords;

        // Getters and setters
}
