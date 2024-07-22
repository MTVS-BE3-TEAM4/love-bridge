package com.jolipjo.lovebridge.domain.member.entity;

public class Member {
    private Long id;
    private Integer secretId;
    private String email;
    private String nickname;
    private String password;
    private String role;
    private String birth;
    private String gender;
    private Boolean marketingAgree;

    public Boolean getMarketingAgree() {
        return marketingAgree;
    }

    public void setMarketingAgree(Boolean marketingAgree) {
        this.marketingAgree = marketingAgree;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSecretId() {
        return secretId;
    }

    public void setSecretId(Integer secretId) {
        this.secretId = secretId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", secretId=" + secretId +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", birth='" + birth + '\'' +
                ", gender='" + gender + '\'' +
                ", marketingAgree=" + marketingAgree +
                '}';
    }
}
