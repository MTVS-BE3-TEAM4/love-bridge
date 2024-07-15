package com.jolipjo.lovebridge.domain.member.dto;

public class FindPasswordRequestDTO {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FindPasswordRequestDTO{" +
                "email='" + email + '\'' +
                '}';
    }
}
