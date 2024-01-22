package com.lockgenius.passwordGenerator.Dto;

public class UserRegistration {

    private String username;
    private String email;
    private String password;


    // Constructeur avec paramètres (si nécessaire)
    public UserRegistration(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getter pour le nom d'utilisateur
    public String getUsername() {
        return username;
    }

    // Setter pour le nom d'utilisateur
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter pour l'adresse e-mail
    public String getEmail() {
        return email;
    }

    // Setter pour l'adresse e-mail
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter pour le mot de passe
    public String getPassword() {
        return password;
    }

    // Setter pour le mot de passe
    public void setPassword(String password) {
        this.password = password;
    }
}
