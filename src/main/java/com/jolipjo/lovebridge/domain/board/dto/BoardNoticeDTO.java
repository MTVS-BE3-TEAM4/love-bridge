package com.jolipjo.lovebridge.domain.board.dto;

import java.util.Date;

public class BoardNoticeDTO {
    private int id;
    private int memberId;
    private String title;
    private String date;
    private String nickname;

    public BoardNoticeDTO() {}

    public BoardNoticeDTO(int id, int memberId, String title, String date, String nickname) {
        this.id = id;
        this.memberId = memberId;
        this.title = title;
        this.date = date;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "BoardNoticeDTO{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}