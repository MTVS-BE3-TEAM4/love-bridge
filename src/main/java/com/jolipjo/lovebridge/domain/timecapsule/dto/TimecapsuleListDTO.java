package com.jolipjo.lovebridge.domain.timecapsule.dto;

import org.springframework.web.bind.annotation.GetMapping;

public class TimecapsuleListDTO {

    private String email;// 이메일

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
