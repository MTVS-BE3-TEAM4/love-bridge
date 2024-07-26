package com.jolipjo.lovebridge.domain.Game.DTO;

public class GameDTO {

    public String myName;
    public String partnerName;
    public Integer attendCnt; // 출석일수
    public String mission;

    public GameDTO(String myName, String partnerName, Integer attendCnt, String mission) {
        this.myName = myName;
        this.partnerName = partnerName;
        this.attendCnt = attendCnt;
        this.mission = mission;
    }

    public GameDTO() {}


    public String getMyName() {
        return myName;
    }

    public String getPartnerName() {

        return partnerName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }


    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public Integer getAttendCnt() {
        return attendCnt;
    }

    public void setAttendCnt(Integer attendCnt) {
        this.attendCnt = attendCnt;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
}
