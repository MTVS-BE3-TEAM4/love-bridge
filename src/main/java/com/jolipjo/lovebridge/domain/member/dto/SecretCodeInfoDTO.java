package com.jolipjo.lovebridge.domain.member.dto;

import com.jolipjo.lovebridge.domain.member.entity.Member;

public class SecretCodeInfoDTO {
    private String secret_code;
    private Member m_member;
    private Member f_member;


    public String getSecret_code() {
        return secret_code;
    }

    public void setSecret_code(String secret_code) {
        this.secret_code = secret_code;
    }

    public Member getM_member() {
        return m_member;
    }

    public void setM_member(Member m_member) {
        this.m_member = m_member;
    }

    public Member getF_member() {
        return f_member;
    }

    public void setF_member(Member f_member) {
        this.f_member = f_member;
    }

    @Override
    public String toString() {
        return "SecretCodeInfoDTO{" +
                "secret_code='" + secret_code + '\'' +
                ", m_member=" + m_member +
                ", f_member=" + f_member +
                '}';
    }
}
