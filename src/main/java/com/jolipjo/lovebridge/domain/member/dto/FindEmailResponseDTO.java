package com.jolipjo.lovebridge.domain.member.dto;

public class FindEmailResponseDTO {
    private boolean isExist;// 이메일이 존재하는가?

    public boolean getIsExist() {
        return isExist;
    }

    public void setIsExist(boolean exist) {
        isExist = exist;
    }
}
