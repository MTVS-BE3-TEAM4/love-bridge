package com.jolipjo.lovebridge.domain.board.dto;

import java.util.Date;

public class BoardNoticeDTO {
    private int id;
    private int memberId;
    private String title;
    private Date date;

    public BoardNoticeDTO() {
    }

    public BoardNoticeDTO(int id, int memberId, String title, Date date) {
        this.id = id;
        this.memberId = memberId;
        this.title = title;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BoardNoticeDTO{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}