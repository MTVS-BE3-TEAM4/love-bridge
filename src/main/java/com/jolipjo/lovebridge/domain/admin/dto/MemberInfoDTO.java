package com.jolipjo.lovebridge.domain.admin.dto;

public class MemberInfoDTO {
    private Long id;
    private String email;
    private String secretCode;
    private String nickname;
    private String role;
    private String birth;
    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "MemberInfoDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", secretCode='" + secretCode + '\'' +
                ", nickname='" + nickname + '\'' +
                ", role='" + role + '\'' +
                ", birth='" + birth + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
