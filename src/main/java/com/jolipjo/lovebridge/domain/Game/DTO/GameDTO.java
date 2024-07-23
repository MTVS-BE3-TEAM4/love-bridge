package com.jolipjo.lovebridge.domain.Game.DTO;

public class GameDTO {

    public String myName;
    public String partnerName;
    public Integer cnt = 0; // 출석일수
    public String mission;

    public GameDTO(String myName, String partnerName, Integer cnt, String mission) {
        this.myName = myName;
        this.partnerName = partnerName;
        this.cnt = cnt;
        this.mission = mission;
    }

    public GameDTO() {}


    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
}
