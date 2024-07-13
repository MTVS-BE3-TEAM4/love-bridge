package com.jolipjo.lovebridge.domain.member.dto;

public class FindPasswordResponseDTO {
    private boolean passwordReset;

    public boolean isPasswordReset() {
        return passwordReset;
    }

    public void setPasswordReset(boolean passwordReset) {
        this.passwordReset = passwordReset;
    }
}
