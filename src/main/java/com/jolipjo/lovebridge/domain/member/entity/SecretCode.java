package com.jolipjo.lovebridge.domain.member.entity;

public class SecretCode {
    private Long couple_id;
    private String secret_code;
    private Long m_member_id;
    private Long f_member_id;


    public Long getCouple_id() {
        return couple_id;
    }

    public void setCouple_id(Long couple_id) {
        this.couple_id = couple_id;
    }

    public String getSecret_code() {
        return secret_code;
    }

    public void setSecret_code(String secret_code) {
        this.secret_code = secret_code;
    }

    public Long getM_member_id() {
        return m_member_id;
    }

    public void setM_member_id(Long m_member_id) {
        this.m_member_id = m_member_id;
    }

    public Long getF_member_id() {
        return f_member_id;
    }

    public void setF_member_id(Long f_member_id) {
        this.f_member_id = f_member_id;
    }

    @Override
    public String toString() {
        return "SecretCode{" +
                "couple_id=" + couple_id +
                ", secret_code='" + secret_code + '\'' +
                ", m_member_id=" + m_member_id +
                ", f_member_id=" + f_member_id +
                '}';
    }
}
