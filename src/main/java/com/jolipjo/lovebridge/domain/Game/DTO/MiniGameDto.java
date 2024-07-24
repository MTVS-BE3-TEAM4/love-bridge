package com.jolipjo.lovebridge.domain.Game.DTO;

import java.util.Date;

public class MiniGameDto {

    private Long id;
    private Long memberId;
    private String attendCnt;
    private Date date;
    private String mission;

    public MiniGameDto(Long id, Long memberId, String attendCnt, Date date, String mission) {
        this.id = id;
        this.memberId = memberId;
        this.attendCnt = attendCnt;
        this.date = date;
        this.mission = mission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getAttendCnt() {
        return attendCnt;
    }

    public void setAttendCnt(String attendCnt) {
        this.attendCnt = attendCnt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
}
