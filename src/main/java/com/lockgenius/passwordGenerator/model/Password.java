package com.lockgenius.passwordGenerator.model;

public class Password {
    private String value;

    public Password(String value) {
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
