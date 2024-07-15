package com.jolipjo.lovebridge.domain.member.dto;


public class FindEmailRequestDTO {
    private String email;// 이메일

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FindEmailRequestDTO{" +
                "email='" + email + '\'' +
                '}';
    }
}
