package com.jolipjo.lovebridge.domain.member.dto;

import java.util.Date;

public class JoinRequestDTO {
    private String email;
    private String password;
    private String nickname;
    private Date birth;
    private String gender;
    private Boolean marketingAgree;

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getMarketingAgree() {
        return marketingAgree;
    }

    public void setMarketingAgree(Boolean marketingAgree) {
        this.marketingAgree = marketingAgree;
    }
}
