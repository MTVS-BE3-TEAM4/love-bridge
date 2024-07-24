package com.jolipjo.lovebridge.domain.Game.DTO;

public class GameDTO {

    public String myName;
    public String partnerName;
    public String attendCnt; // 출석일수
    public String mission;

    public GameDTO(String myName, String partnerName, String attendCnt, String mission) {
        this.myName = myName;
        this.partnerName = partnerName;
        this.attendCnt = attendCnt;
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

    public String getAttendCnt() {
        return attendCnt;
    }

    public void setAttendCnt(String attendCnt) {
        this.attendCnt = attendCnt;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
}
