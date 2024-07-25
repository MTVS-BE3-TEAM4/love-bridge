package com.jolipjo.lovebridge.domain.board.dto;

import java.time.LocalDateTime;

public class BoardEditDTO {

    private int id;
    private int memberId;
    private String title;
    private LocalDateTime date;
    private String text;
    private String field;

    public BoardEditDTO() {}

    public BoardEditDTO(int id, int memberId, String title, LocalDateTime date, String text, String field) {
        this.id = id;
        this.memberId = memberId;
        this.title = title;
        this.date = date;
        this.text = text;
        this.field = field;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "BoardEditDTO{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", text='" + text + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
