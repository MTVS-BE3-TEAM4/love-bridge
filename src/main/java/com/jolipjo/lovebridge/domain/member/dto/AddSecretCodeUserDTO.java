package com.jolipjo.lovebridge.domain.member.dto;

public class AddSecretCodeUserDTO {
    private Long secretCodeId;
    private Long memberId;

    public Long getSecretCodeId() {
        return secretCodeId;
    }

    public void setSecretCodeId(Long secretCodeId) {
        this.secretCodeId = secretCodeId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
