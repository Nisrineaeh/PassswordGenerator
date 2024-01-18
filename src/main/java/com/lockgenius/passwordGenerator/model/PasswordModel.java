package com.lockgenius.passwordGenerator.model;

public class PasswordModel {
    private String value;

    public PasswordModel(String value) {
        this.value = value;
    }

    // Getters et setters

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
